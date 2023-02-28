package com.project.board.controller;

import com.project.board.entity.Member;
import com.project.board.service.BasicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
public class BasicController {

    @Autowired
    private BasicService basicService;

    // 로그인
    @GetMapping("/board/login")
    public String login(){

        return "basic/login";
    }

    // 로그인 처리
    @RequestMapping(value="/board/loginEnd", method = RequestMethod.POST)
    public String loginEnd(Model model, ModelAndView mav,Member member){

        return "/board/home";
    }


    // 회원가입
    @GetMapping("/board/join")
    public String join(){

        return "basic/join";
    }

    // 회원가입 아이디 중복확인(Ajax)
    @ResponseBody
    @RequestMapping(value="/board/idCheck", method = RequestMethod.POST)
    public String idCheck(Model model, Member member){

        if(member.getId().isEmpty()) {
            return "-1";
        }
        List<Member> findIdCheck = basicService.findIdCheck(member.getId());

        if(findIdCheck.size()>1){ // 멤버 존재
            return "0";
        }
        model.addAttribute("id",findIdCheck); // 사용가능
        return "1";

    }
    
    // 회원가입 저장
    @PostMapping("/board/joinEnd")
    public ModelAndView joinEnd(Model model, ModelAndView mav, Member member){

        try{
            Member n = basicService.joinEnd(member);

            if(!n.getId().isEmpty()){
                mav.addObject("message", "회원가입이 성공적으로 처리되었습니다.");
                mav.addObject("loc", "http://localhost:8080/board/home");
                return mav;
            }
                String message = "회원가입 실패.";
                String loc = "javascript:history.back()";

                mav.addObject("message", message);
                mav.addObject("loc", loc);

        }catch (Exception e) {
            e.printStackTrace();
        }
        return mav;
    }
    
    // 로그아웃
    @GetMapping("/logout")
    public String logout(){

        return "redirect:boardList";
    }

}
