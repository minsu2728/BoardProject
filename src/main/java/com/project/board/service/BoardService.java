package com.project.board.service;


import com.project.board.entity.Board;
import com.project.board.repository.InterBoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService implements InterBoardService {

    @Autowired
    private InterBoardRepository boardRepository;

    @Override
    public void insertBoard(Board dto) throws Exception {
        boardRepository.save(dto);
    }

    @Override
    public void updateBoard(Board dto) throws Exception {
        boardRepository.save(dto); // save : 행이 존재하면 update, 행이 없으면 insert 해줌
    }

    @Override
    public void deleteBoard(long num) throws Exception {
        boardRepository.deleteById(num);
    }

    @Override
    public List<Board> listBoard() throws Exception {
        List<Board> boardList = boardRepository.findAll();
        return boardList;
    }

}
