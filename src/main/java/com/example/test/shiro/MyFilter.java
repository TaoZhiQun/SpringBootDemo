package com.example.test.shiro;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;

public class MyFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println(servletRequest.getParameter("name"));
        HttpServletRequest httpServletRequest = (HttpServletRequest)servletRequest;
        HttpServletResponseWrapper wrapper = new HttpServletResponseWrapper((HttpServletResponse) servletResponse);
        if(httpServletRequest.getRequestURI().contains("/index") ||
                httpServletRequest.getRequestURI().contains("/online")||
                httpServletRequest.getRequestURI().contains("/login")){
                filterChain.doFilter(servletRequest,servletResponse);
        }else {
            wrapper.sendRedirect("/login");
        }

    }

    @Override
    public void destroy() {

    }
}
