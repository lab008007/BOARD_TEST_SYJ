package com.aloha.mybatis.service;

import java.util.List;

import com.aloha.mybatis.dto.Board;
import com.aloha.mybatis.dto.Page;

public interface BoardService {

  
    public List<Board> list(Page page) throws Exception;
    
    public int count() throws Exception;
    
    public Board select(int no) throws Exception;
    
    public int insert(Board board) throws Exception;
    
    public int update(Board board) throws Exception;
   
    public int delete(int no) throws Exception;
    
}