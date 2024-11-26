package com.aloha.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.aloha.mybatis.dto.Board;
import com.aloha.mybatis.dto.Page;

@Mapper
public interface BoardMapper {

    
    public List<Board> list(Page page) throws Exception;
   
    public Board select(int no) throws Exception;
    
    public int insert(Board board) throws Exception;
  
    public int update(Board board) throws Exception;
   
    public int delete(int no) throws Exception;
    
    
    public int maxPk() throws Exception;
    
    public int count() throws Exception;
    
}