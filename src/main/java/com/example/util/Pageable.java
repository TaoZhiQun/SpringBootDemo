package com.example.util;

public interface Pageable {
    int getPageNo();

    void setPageNo(int pageNo);

    int getPageSize();

    void setPageSize(int pageSize);

    long getTotalRecord();

    void setTotalRecord(long total);

    int getTotalPage();

    void setTotalPage(int totalPage);
}
