package com.aloha.mybatis.dto;


import lombok.Data;


@Data
public class Page {
    // 페이징 기본값
    private static final int PAGE_NUM = 1;  
    private static final int ROWS = 10;      
    private static final int COUNT = 10;     

    // ✅ 필수 정보
    private int page;
    private int rows;
    private int count;
    private int total;

    // ⭐ 수식 정보
    private int start;
    private int end;
    private int first;
    private int last;

    private int prev;
    private int next;

    private int index;

    
    public Page() {
        this(0);
    }
    
    public Page(int total) {
        this(PAGE_NUM, total);
    }
    
    public Page(int page, int total) {
        this(page, ROWS, COUNT, total);
    }
    
    public Page(int page, int rows, int count, int total) {
        this.page = page;
        this.rows = rows;
        this.count = count;
        this.total = total;
        calc();
    }

    
    public void setTotal(int total) {
        this.total = total;
        calc();
    }

    
    public void calc() {
        
        this.first = 1;
        
        this.last = (this.total - 1) / rows + 1;
        
        this.start = ( (page-1) / count ) * count + 1;
        
        this.end = ( (page-1) / count + 1 ) * count;
        if( this.end > this.last ) this.end = this.last;

        
        this.prev = this.page - 1;
        
        this.next = this.page + 1;
        
        this.index = (this.page - 1) * this.rows;
    }
    
}
