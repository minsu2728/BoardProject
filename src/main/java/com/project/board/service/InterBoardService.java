package com.project.board.service;


import com.project.board.entity.Board;

import java.util.List;

public interface InterBoardService {

    public void insertBoard(Board entity) throws Exception;
    public void updateBoard(Board entity) throws Exception;
    public void deleteBoard(long num) throws Exception;

    public List<Board> listBoard() throws Exception;
 /*   public Board viewGuest(long num) throws Exception;*/

}
