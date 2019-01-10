package com.example.test.responsibility;

public class SensitiveFilter implements Filter {
    @Override
    public void doFilter(Request request, Response response, FilterChain chain) {
        request.requestStr = request.requestStr.replace("被就业","就业").replace("敏感","") +"---sensitiveFilter()";
        chain.doFilter(request,response,chain);
        response.responseStr+="---sensitiveFilter()";
    }
}
