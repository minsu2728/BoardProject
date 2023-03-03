package com.project.board.service;


import com.project.board.entity.Comment;
import com.project.board.repository.InterBasicRepository;
import com.project.board.repository.InterCommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    @Autowired
    private InterCommentRepository commentRepository;

    // 댓글 등록
    public void commentup(Comment comment) {
        commentRepository.save(comment);
    }
}
