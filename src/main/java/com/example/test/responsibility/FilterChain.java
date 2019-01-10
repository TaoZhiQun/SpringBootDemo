package com.example.test.responsibility;

import java.util.ArrayList;
import java.util.List;

public class FilterChain implements Filter {
    List<Filter> filterList = new ArrayList<Filter>();
    int index =0;
    public FilterChain addFilter(Filter f){
        filterList.add(f);
        return this;
    }
    @Override
    public void doFilter(Request request, Response response, FilterChain chain) {
        if(index == filterList.size()){
            return;
        }
        Filter f = filterList.get(index);
        index++;
        f.doFilter(request,response,chain);
    }
}
