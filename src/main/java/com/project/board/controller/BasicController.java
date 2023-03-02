package com.project.board.controller;

import com.project.board.entity.Member;
import com.project.board.service.BasicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class BasicController {

    @Autowired
    private BasicService basicService;

    // 로그인
    @GetMapping("/login")
    public String login(){

        return "basic/login";
    }



    // 로그인 처리
    @RequestMapping(value="/loginEnd", method = RequestMethod.POST)
    public String loginEnd(Model model, Member member, HttpSession session){  // BindResult 검증 오류가 발생할 경우 오류 내용을 보관하는 스프링 프레임워크에서 제공하는 객체
        System.out.println(member.getId());
        System.out.println(member.getPwd());

        Member loginuser = basicService.login(member);

        session.setAttribute("user",loginuser.getId());
        session.setAttribute("username",loginuser.getName());
        model.addAttribute("loginuser",loginuser);

        System.out.println("세션"+ loginuser.getId());
        System.out.println("모델"+ loginuser);


        if(loginuser == null) {

            model.addAttribute("message","로그인 실패");
            model.addAttribute("loc","javascript:history.back()");
            return "msg";
        }

        model.addAttribute("message","로그인성공");
        model.addAttribute("loc","http://localhost:8080/boardHome");

       return "msg";
    }




    // 회원가입
    @GetMapping("/join")
    public String join(){

        return "basic/join";
    }

    // 회원가입 아이디 중복확인(Ajax)
    @ResponseBody
    @RequestMapping(value="/board/idCheck", method = RequestMethod.POST)
    public String idCheck(Model model, Member member){

        System.out.println(member.getId());

        if(member.getId().isEmpty()) {
            return "-1";
        }
        List<Member> findIdCheck = basicService.findIdCheck(member.getId());

        System.out.println("!!!" + findIdCheck );


        if(findIdCheck.size() > 0){ // 멤버 존재
            return "null";
        }
        model.addAttribute("id",findIdCheck); // 사용가능
        return "1";

    }
    
    // 회원가입 저장
    @PostMapping("/board/joinEnd")
    public String joinEnd(Model model, Member member){

        try{
            Member n = basicService.joinEnd(member);

            if(!n.getId().isEmpty()){

                String loc = "http://localhost:8080/login";
                model.addAttribute("message", "회원가입이 성공적으로 처리되었습니다.");
                model.addAttribute("loc", loc);
                return "msg";
            }
                String loc = "javascript:history.back()";

                model.addAttribute("message", "회원가입 실패");
                model.addAttribute("loc", loc);

        }catch (Exception e) {
            e.printStackTrace();
        }
        return "msg";
    }
    
    // 로그아웃
    @GetMapping("/logout")
    public String logout(){

        return "redirect:boardHome";
    }

}
