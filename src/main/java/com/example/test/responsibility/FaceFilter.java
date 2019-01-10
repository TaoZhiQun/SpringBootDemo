package com.example.test.responsibility;

public class FaceFilter implements Filter {
    @Override
    public void doFilter(Request request, Response response, FilterChain chain) {
        request.requestStr = request.requestStr.replace(":):", "^V^") +"-------FaceFilter()";
        chain.doFilter(request,response,chain);
        response.responseStr += "---FaceFilter()";
    }
}
