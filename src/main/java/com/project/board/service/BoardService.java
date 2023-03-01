package com.project.board.service;

import com.project.board.entity.Board;
import com.project.board.repository.InterBoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    @Autowired
    private InterBoardRepository boardRepository;

    // 글 리스트 불러오기
    public List<Board> boardList() {
        return boardRepository.findAll();
    }





}
