package com.project.board.service;

import com.project.board.entity.Member;
import com.project.board.repository.InterBasicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class BasicService {

    @Autowired
    private InterBasicRepository basicRepository;


    // 회원가입 아이디 중복확인(Ajax)
    public List<Member> findIdCheck(String id) {
        return basicRepository.findAllById(id);
    }

    // 회원가입
    public Member joinEnd(Member member) {
        return basicRepository.save(member);
    }



    // 로그인
    public Member login(Member member) {

        Member loginuser =  basicRepository.findById(member.getId());

        if(loginuser == null){
            return null;
        }
        if(!loginuser.getPwd().equals(member.getPwd())){
            return null;
        }
        System.out.println("!!!"+ basicRepository.findById(member.getId()));
        return loginuser;
    }





} // public class BasicService {
