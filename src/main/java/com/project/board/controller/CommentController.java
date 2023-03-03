package com.project.board.controller;

import com.project.board.entity.Comment;
import com.project.board.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;

    // 댓글작성
    @ResponseBody
    @RequestMapping(value = "/board/commentup", method = RequestMethod.POST)
    public String commentup(Comment comment, Model model){

        System.out.println("@@@" + comment.getFk_mnum());
        System.out.println("@@@" + comment.getComtitle());
        System.out.println("@@@" + comment.getFk_subno());

         commentService.commentup(comment);
         model.addAttribute("comment","comment");
        return "return";

    }

}
