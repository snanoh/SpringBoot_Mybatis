package com.hancom.service;


import com.hancom.entity.Board;
import com.hancom.entity.Response;
import com.hancom.persistence.Board_DAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Board_Service {

    @Autowired
    private Board_DAO boardDao;

    public Response save(Board board) throws Exception{
        Response res = new Response();
        if(board.getTitle() == null || board.getContent() == null || board.getWriter() == null){
            res.setCode("9000");
            res.setMessage("Parameter dose not exists");
            return res;
        }
        try {
            boardDao.saveBoard(board);
            res.setCode("0000");
            res.setMessage("Success");
        }catch (Exception e){
            e.printStackTrace();
            res.setCode("9999");
            res.setMessage("Server Error");
        }
        return res;
    }
}
