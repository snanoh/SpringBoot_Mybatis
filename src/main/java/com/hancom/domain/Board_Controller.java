package com.hancom.domain;


import com.hancom.entity.Board;
import com.hancom.entity.Response;
import com.hancom.service.Board_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/board")
public class Board_Controller {
    @Autowired
    private Board_Service boardService;

    @PostMapping("")
    public Response create(@RequestBody Board board){
        Response res = boardService.save(board);
        return res;
    }

    @GetMapping("")
    public String read(){
        return "test";
    }

    @GetMapping("/{idx}")
    public void readDetail(@PathVariable int idx){
    }

    @PutMapping("/{idx}")
    public void put(@PathVariable int idx, @RequestBody Board board){
    }

    @DeleteMapping("/{idx}")
    public void delete(@PathVariable int idx){
    }
}
