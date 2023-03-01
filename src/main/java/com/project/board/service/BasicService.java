package com.project.board.service;

import com.project.board.entity.Member;
import com.project.board.repository.InterBasicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public boolean login(Member member) {

        Member findUserID =  basicRepository.findById(member.getId());

        if(findUserID == null){
            return false;
        }

        if(!findUserID.getPwd().equals(member.getPwd())){
            return false;
        }

        return true;
    }





} // public class BasicService {
