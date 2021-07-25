package com.hancom.persistence;

import com.hancom.entity.Board;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public interface Board_DAO {
    //게시판 생성
    void insertBoard(Board board) throws Exception;

    //게시판 전체 내역 수 조회
    int selectBoardAllCount() throws Exception;

    //게시판 리스트 조회
    List<Board> selectBoardList(HashMap<String, Object> conditionMap) throws Exception;

    //게시판 상세 내역 조회
    Board selectBoardDetail(HashMap<String, Object> conditionMap) throws Exception;

    //게시판 조회 Hit 증가 업데이트
    void updateBoardHit(HashMap<String, Object> conditionMap) throws Exception;

    //게시판 수정
    void updateBoard(HashMap<String, Object> conditionMap) throws Exception;

    //게시판 최초 등록자 조회
    String selectBoardWriter(HashMap<String, Object> conditionMap) throws Exception;

    //게시판 삭제
    void deleteBoard(HashMap<String, Object> conditionMap) throws Exception;
}
