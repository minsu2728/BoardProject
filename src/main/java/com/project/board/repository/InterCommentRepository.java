package com.project.board.repository;


import com.project.board.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterCommentRepository extends JpaRepository<Comment, Long> {



}
