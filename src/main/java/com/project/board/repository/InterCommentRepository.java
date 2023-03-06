package com.project.board.repository;


import com.project.board.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InterCommentRepository extends JpaRepository<Comment, Integer> {


    // 댓글리스트
    List<Comment> findByFkSubno(Integer subno);
}
