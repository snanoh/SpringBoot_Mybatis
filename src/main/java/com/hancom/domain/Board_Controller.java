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
    public Response create(@RequestBody Board board) throws Exception {
        return boardService.save(board);
    }

    @GetMapping("")
    public Response readList(@RequestParam int pageNum, @RequestParam int listSize) throws Exception {
        return boardService.readList(pageNum, listSize);
    }

    @GetMapping("/{idx}")
    public Response readDetail(@PathVariable int idx) throws Exception {
        return boardService.readDetail(idx);
    }

    @PutMapping("/{idx}")
    public Response put(@PathVariable int idx, @RequestBody Board board) throws Exception {
        return boardService.updateBoard(idx, board);
    }

    @DeleteMapping("/{idx}")
    public Response delete(@PathVariable int idx, @RequestParam String deleteId) throws Exception {
        return boardService.deleteBoard(idx, deleteId);
    }
    @RequestMapping("/test")
    public String test(){
    	return "test";
    }
}
