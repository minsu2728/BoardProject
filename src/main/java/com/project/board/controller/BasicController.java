package com.project.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BasicController {

    @GetMapping("/board/login")
    public String login(){

        return "basic/login";
    }

    @GetMapping("/board/join")
    public String join(){



        return "basic/join";
    }

    @GetMapping("/logout")
    public String logout(){

        return "redirect:boardList";
    }

}
