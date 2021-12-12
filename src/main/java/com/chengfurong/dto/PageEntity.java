package com.chengfurong.dto;

public class PageEntity {

    /**
     * 一页的行数
     */
    private int pageSize;
    /**
     * 当前页的页码:从1开始
     */
    private int pageCurrent;
    /**
     * 总页数
     */
    private int pageCount;
    /**
     * 总行数
     */
    private long pageRowTotal;
    /**
     * 当前页的开始行:从0开始
     */
    private int start;
    /**
     * 当前页的结束行
     */
    private int end;

    public PageEntity(){

    }

    public PageEntity(int pageCurrent, int pageSize, long pageRowTotal){
        this.pageRowTotal=pageRowTotal;
        this.pageCurrent=pageCurrent;
        this.pageSize=pageSize;
        this.computePageCount();
    }
    public PageEntity(int pageCurrent,int pageSize, long pageRowTotal,int pages){
        this.pageRowTotal=pageRowTotal;
        this.pageCurrent=pageCurrent;
        this.pageSize=pageSize;
        this.pageCount = pages;
//        this.computePageCount();
    }
    public void computePageCount(){
        //计算总页数
        this.pageCount = (int)(this.getPageRowTotal()/this.getPageSize()) +
                this.getPageRowTotal()%this.getPageSize()==0?0:1;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageCurrent() {
        return pageCurrent;
    }

    public void setPageCurrent(int pageCurrent) {
        this.pageCurrent = pageCurrent;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public long getPageRowTotal() {
        return pageRowTotal;
    }

    public void setPageRowTotal(long pageRowTotal) {
        this.pageRowTotal = pageRowTotal;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }
}
