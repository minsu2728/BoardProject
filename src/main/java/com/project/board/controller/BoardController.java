package com.project.board.controller;

import com.project.board.entity.Board;
import com.project.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;


    // 첫화면
    @GetMapping("/boardHome")
    public String login(){
       /*try{
            List<Board> boardList = boardService.boardList();
            model.addAttribute("boardList", boardList);
        } catch(Exception e) {
            e.printStackTrace();
        }*/
        return"board/boardHome";
    }

/*    Model model, Board board*/


    // 글쓰기
    @GetMapping("/board/boardWrite")
    public String write(){
      /*  try{


        }catch(Exception e) {
            e.printStackTrace();
        }*/
        return"board/boardWrite";

    }


    // 글쓰기 처리
    @RequestMapping("/board/wirteGo")
    public String writeGo(Board board){

        System.out.println(board.getSubject());
        System.out.println(board.getContnent());
        return "";
    }








}
