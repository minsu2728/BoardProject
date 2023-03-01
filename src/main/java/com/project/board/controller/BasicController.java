package com.project.board.controller;

import com.project.board.entity.Member;
import com.project.board.service.BasicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public String loginEnd(Model model, ModelAndView mav, Member member, HttpServletResponse  response){  // BindResult 검증 오류가 발생할 경우 오류 내용을 보관하는 스프링 프레임워크에서 제공하는 객체
        System.out.println(member.getId());
        System.out.println(member.getPwd());

        boolean bool = true;
        /*basicService.login(member);*/
        bool = basicService.login(member);

        String result = String.valueOf(bool);
        if(result.equals(false)){
            return "board/boardWrite";
        }

/*

        mav.addObject("message", "로그인 성공적으로 처리되었습니다.");
        mav.addObject("loc", "http://localhost:8080/board/boardHome");
*/
        model.addAttribute("result", result);

        //쿠키에 시간 정보를 주지 않으면 세션 쿠기(브라우저 종료시 모두 종료)
        Cookie idCookie = new Cookie("userid", member.getId());
        response.addCookie(idCookie);

       return "board/boardHome";
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

            /*member.setRegdate(LocalDate.now());*/
       /*     Member joinEnd = this.member.save(member);*/
            Member n = basicService.joinEnd(member);

            if(!n.getId().isEmpty()){
                mav.addObject("message", "회원가입이 성공적으로 처리되었습니다.");
                mav.addObject("loc", "http://localhost:8080/board/boardHome");
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

        return "redirect:boardHome";
    }

}
