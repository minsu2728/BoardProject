package com.project.board.controller;

import com.project.board.entity.Board;
import com.project.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;


    // 첫화면
    @GetMapping("/boardHome")
    public String home(Model model, Board board
                        , @PageableDefault(page = 0, size = 5, sort = "subno", direction = Sort.Direction.DESC ) Pageable pageable) {// @PageableDefault은 페이징처리할 때 필요한 기능
                        /*, String searchKeyword)*/
/*

        Page<Board> searchList = null;
        if(searchKeyword == null){
            searchList = boardService.boardList(pageable);
        }else{
            searchList = boardService.boardList(searchKeyword);

        }
*/

        Page<Board> pageList =  boardService.boardList(pageable);
        System.out.println("!!!" +  boardService.boardList(pageable));

        int nowPage = pageList.getPageable().getPageNumber() +1;
        int startPage = Math.max( nowPage - 4 ,1);
        int endPage = Math.min(nowPage + 5, pageList.getTotalPages()) ;

        model.addAttribute("boardList",pageList);
        model.addAttribute("nowPage",nowPage);
        model.addAttribute("startPage",startPage);
        model.addAttribute("endPage",endPage);

        return"board/boardHome";
    }


    // 글쓰기
    @GetMapping("/board/boardWrite")
    public String write(){
        return"board/boardWrite";
    }


    /// 글작성 처리
    @PostMapping("/board/wirteGo")
    public String writeGo(Board board, Model model){
        System.out.println(board.getSubject());
        System.out.println(board.getContent());

        boardService.boardWrite(board);
        return "redirect:/boardHome";
    }

    // 게시글 상세
    @GetMapping("/board/boardView")
    public String boardView(Model model, Long subno){
        model.addAttribute("board",boardService.boardView(subno));
        return "board/boardView";
    }

    // 특정글 삭제
    @GetMapping("/board/boardDelete")
    public String boardDelete(Long subno){
        boardService.boardDelete(subno);
        return "redirect:/boardHome";
    }

    // 특정글 수정
    @GetMapping("/board/override/{subno}") // {subno}은 페스베리어블이라고 한다.
    public String boardOverride(@PathVariable("subno") Long subno, Model model){ // 페스베리어블은 url이 들어왔을때 {}을 인식해서 들어온다.

        // 기존의 데이터를 담아와야한다.
        model.addAttribute("board",boardService.boardView(subno));

        return "board/boardOverride";
    }

    @PostMapping("/board/boardUpdate/{subno}")
    public String boardUpdate(@PathVariable("subno") Long subno,Board board){

        Board boardTemp = boardService.boardView(subno);
        boardTemp.setSubject(board.getSubject());
        boardTemp.setContent(board.getContent());

        boardService.boardWrite(board);

       /* return "redirect:/board/boardView";*/

        return "redirect:/boardHome";
    }


    /*
     model.addAttribute("board", boardService.boardUpdate(Board.subno));*/

    /*---------------------------------------------------------------------------------*/



/*


*/

  /*

*/





}
