package com.aloha.mybatis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.aloha.mybatis.dto.Board;
import com.aloha.mybatis.dto.Page;
import com.aloha.mybatis.service.BoardService;

import lombok.extern.slf4j.Slf4j;





@Slf4j                     
@Controller                 
@RequestMapping("/board")   
                            
public class BoardController {
    
    
    @Autowired                              
    private BoardService boardService;      

    
    @GetMapping("/list")
    public String list(Model model, 
                      @RequestParam(name = "page",defaultValue = "1") int page,
                      @RequestParam(name = "rows",defaultValue = "10") int rows) throws Exception {
        
        // 전체 게시글 수
        int total = boardService.count();
        
        // 페이지 객체 생성
        Page pageObj = new Page(page, rows, 10, total);
        
        // 게시글 목록 조회
        List<Board> boardList = boardService.list(pageObj);
        
        model.addAttribute("boardList", boardList);
        model.addAttribute("page", pageObj);
        
        return "/board/list";
    }
    
    
    @GetMapping("/read")
    public String read(@RequestParam("no") int no, Model model) throws Exception {
        
        Board board = boardService.select(no);
        
        model.addAttribute("board", board);
        
        return "/board/read";
    }
    
    
    @GetMapping("/insert")
    public String insert() {

        return "/board/insert";
    }

    
    @PostMapping("/insert")
    public String insertPro(Board board) throws Exception {
        
        int result = boardService.insert(board);
        
        if( result > 0 ) {
            return "redirect:/board/list";
        }
        
        return "redirect:/board/insert?error";  
    }
    
    
    @GetMapping("/update")
    public String update(@RequestParam("no") int no, Model model) throws Exception {
        Board board = boardService.select(no);
        model.addAttribute("board", board);
        return "/board/update";
    }

    
    @PostMapping("/update")
    public String updatePro(Board board) throws Exception {
        int result = boardService.update(board);

        if( result > 0 ) {
            return "redirect:/board/list";
        }
        int no = board.getNo();
        return "redirect:/board/update?no="+ no + "&error";
    }
    
    
    @PostMapping("/delete")
    public String delete(@RequestParam("no") int no) throws Exception {
        int result = boardService.delete(no);
        if( result > 0 ) {
            return "redirect:/board/list";
        }
        return "redirect:/board/update?no=" + no + "&error";
    }
    
    
}
