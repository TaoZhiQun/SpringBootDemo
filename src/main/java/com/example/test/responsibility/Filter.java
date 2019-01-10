package com.example.test.responsibility;



public interface Filter {
    void doFilter(Request request, Response response, FilterChain chain);
}
