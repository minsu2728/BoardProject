package com.project.board.service;

import com.project.board.entity.Board;
import com.project.board.repository.InterBasicRepository;
import com.project.board.repository.InterBoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BoardService {

    @Autowired
    private InterBoardRepository boardRepository;

    @Autowired
    private InterBasicRepository basicRepository;

    // 글 리스트 불러오기
    public List<Board> boardList() {
        return boardRepository.findAll();
    }


    //글쓰기
    public void boardWrite(Board board){
        //board.setWriter(basicRepository.findById(board.getFk_mnum()).get().getName());
        boardRepository.save(board);
    }


    // 글 상세보기
    public Board boardView(Long subno) {
        return boardRepository.findById(subno).get();
    }


    // 특정글 삭제
    public void boardDelete(Long subno) {
        boardRepository.deleteById(subno);
    }

/*
    // 검색기능
    public Page<Board> boardSearch(String searchKeyword, Pageable pageable){
        return boardRepository.search(searchKeyword,pageable);
    }*/

    // 페이징처리
    public Page<Board> boardList(Pageable pageable){
        return boardRepository.findAll(pageable);
    }



}
