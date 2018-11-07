package com.example.util;

import java.util.List;

public interface Page<T> {
    static <T> Page getPage(Pageable pageable,List<T> content){
        Page<T> result = new PageImpl();
        result.setContent(content);
        result.setPageNo(pageable.getPageNo());
        result.setPageSize(pageable.getPageSize());
        result.setTotalPage(pageable.getTotalPage());
        result.setTotalRecord(pageable.getTotalRecord());
        return result;
    }

    int getPageNo();

    void setPageNo(int pageNo);

    int getPageSize();

    void setPageSize(int pageSize);

    long getTotalRecord();

    void setTotalRecord(long totalRecord);

    int getTotalPage();

    void setTotalPage(int totalPage);

    List<T> getContent();

    void setContent(List<T> content);

}
