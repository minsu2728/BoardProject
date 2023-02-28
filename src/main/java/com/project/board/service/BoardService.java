package com.project.board.service;

import com.project.board.repository.InterBoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {

    @Autowired
    private InterBoardRepository boardRepository;


}
