package com.project.board.repository;

import com.project.board.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InterBasicRepository extends JpaRepository<Member, Long> {

    // 아이디 중복확인
    List<Member> findAllById(String id);

    // 회원가입







}
