package com.hancom.service;


import com.hancom.entity.Board;
import com.hancom.entity.Response;
import com.hancom.persistence.Board_DAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class Board_Service {

    @Autowired
    private Board_DAO boardDao;

    //게시판 저장
    public Response save(Board board) throws Exception{
        Response res = new Response();
        if(board.getTitle() == null || board.getContent() == null || board.getWriter() == null){
            res.setCode("9000");
            res.setMessage("Parameter dose not exists");
            return res;
        }
        try {
            boardDao.insertBoard(board);
            res.setCode("0000");
            res.setMessage("Success");
        }catch (Exception e){
            e.printStackTrace();
            res.setCode("9999");
            res.setMessage("Server Error");
        }
        return res;
    }

    //게시판 리스트 조회
    public Response readList(int pageNum, int listSize) throws Exception{
        Response res = new Response();
        /* 조건 생성 */
        HashMap<String, Object> conditionMap = new HashMap<>();
        HashMap<String, Object> returnMap = new HashMap<>();
        try{
            if(pageNum == 0){ // pageNum이 0 일 경우 게시물 전체 COUNT
                returnMap.put("BoardCnt", boardDao.selectBoardAllCount());
            }else{
            	conditionMap.put("startIdx" , (pageNum-1)*listSize);
                conditionMap.put("listSize" , listSize);
                returnMap.put("BoardTitleList", boardDao.selectBoardList(conditionMap));
            }
            res.setCode("0000");
            res.setMessage("Success");
        }catch (Exception e){
            e.printStackTrace();
            res.setCode("9999");
            res.setMessage("Server Error");
        }
        return res;
    }

    //게시판 내용 조회
    public Response readDetail(int idx) throws Exception{
        Response res = new Response();
        /* 조건 생성 */
        HashMap<String, Object> conditionMap = new HashMap<>();
        conditionMap.put("idx", idx);
        HashMap<String, Object> returnMap = new HashMap<>();
        try{
            returnMap.put("BoardDetail", boardDao.selectBoardDetail(conditionMap));
            boardDao.updateBoardHit(conditionMap);
            res.setCode("0000");
            res.setMessage("Success");
        }catch (Exception e){
            e.printStackTrace();
            res.setCode("9999");
            res.setMessage("Server Error");
        }
        return res;
    }

    //게시판 수정
    public Response updateBoard(int idx, Board board) throws Exception{
        Response res = new Response();
        /* 조건 생성 */
        HashMap<String, Object> conditionMap = new HashMap<>();
        conditionMap.put("idx"    , idx);
        conditionMap.put("title"  , board.getTitle());
        conditionMap.put("content", board.getContent());
        conditionMap.put("writer" , board.getWriter());
        try{
            String writer = boardDao.selectBoardDetail(conditionMap).getWriter();
            if(board.getWriter().equals(writer)){ // 최초 등록자만 수정 가능
                boardDao.updateBoard(conditionMap);
                res.setCode("0000");
                res.setMessage("Success");
            }else{
                res.setCode("0001");
                res.setMessage("Writer does not matched");
            }
        }catch (Exception e){
            e.printStackTrace();
            res.setCode("9999");
            res.setMessage("Server Error");
        }
        return res;
    }

    //게시판 삭제
    public Response deleteBoard(int idx, String deleteId) throws Exception{
        Response res = new Response();
        /* 조건 생성 */
        HashMap<String, Object> conditionMap = new HashMap<>();
        conditionMap.put("idx"     , idx);
        conditionMap.put("deleteId", deleteId);
        try {
            String writer = boardDao.selectBoardDetail(conditionMap).getWriter();
            if(deleteId.equals(writer)){ // 최초 등록자만 삭제 가능
                boardDao.deleteBoard(conditionMap);
                res.setCode("0000");
                res.setMessage("Success");
            }else{
                res.setCode("0001");
                res.setMessage("Writer does not matched");
            }
        }catch (Exception e){
            e.printStackTrace();
            res.setCode("9999");
            res.setMessage("Server Error");
        }
        return res;
    }
}
