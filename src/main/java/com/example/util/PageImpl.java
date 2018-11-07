package com.example.util;

import java.io.Serializable;
import java.util.List;

public class PageImpl<T> implements Page<T>, Serializable {

    private int pageNo = 1;
    private int pageSize = 10;
    private long totalRecord = -1L;
    private int totalPage;
    private List<T> content;
    public PageImpl() {
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
    public void setTotalRecord(long totalRecord) {
        this.totalRecord = totalRecord;
    }

    @Override
    public int getTotalPage() {
        return this.totalPage;
    }

    @Override
    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    @Override
    public List getContent() {
        return this.content;
    }

    @Override
    public void setContent(List content) {
        this.content = content;
    }
}
