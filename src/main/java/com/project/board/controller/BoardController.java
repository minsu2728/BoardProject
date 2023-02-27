package com.project.board.controller;

import com.project.board.entity.Board;
import com.project.board.service.InterBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class BoardController {

    @Autowired
    private InterBoardService boardService;

    @RequestMapping(value = "/board/login")
    public String login(Model model){
        try{
            List<Board> boardList = boardService.listBoard();
            model.addAttribute("boardList", boardList);
        } catch(Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
