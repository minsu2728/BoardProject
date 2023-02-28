package com.project.board.controller;

import com.project.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/board/home")
    public String boardList(){

        return"board/boardList";
    }

    @GetMapping("board/main")
    public String main(){
        return "board/main";
    }


/*

    @RequestMapping(value = "/boardList")
    public String login(Model model){
        try{
            List<Board> boardList = boardService.listBoard();
            model.addAttribute("boardList", boardList);
        } catch(Exception e) {
            e.printStackTrace();
        }
        return "pages/views/login";
    }

    @GetMapping("boardlist")
    public String write() {

        return "boardList";
    }

*/


}
