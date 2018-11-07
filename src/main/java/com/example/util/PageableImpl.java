package com.example.util;

import java.io.Serializable;

public class PageableImpl implements Pageable, Serializable {
    private int pageNo = 1;
    private int pageSize = 10;
    private long totalRecord = -1L;
    private int totalPage;
    public PageableImpl() {
    }

    public PageableImpl(int pageNo, int pageSize) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
    }
    @Override
    public int getPageNo() {
        return this.pageNo;
    }

    @Override
    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    @Override
    public int getPageSize() {
        return this.pageSize;
    }

    @Override
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public long getTotalRecord() {
        return this.totalRecord;
    }

    @Override
    public void setTotalRecord(long total) {
        this.totalRecord = totalRecord;
        int totalPage = (int)(totalRecord % (long)this.pageSize == 0L ? totalRecord / (long)this.pageSize : totalRecord / (long)this.pageSize + 1L);
        this.setTotalPage(totalPage);
    }

    @Override
    public int getTotalPage() {
        return this.totalPage;
    }

    @Override
    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }
}
