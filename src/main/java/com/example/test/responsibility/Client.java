package com.example.test.responsibility;

public class Client {
    public static void main(String[] args) {
        String msg = ":):,<script>,敏感,被就业,网络授课";
        Request request = new Request();
        request.setRequestStr(msg);
        Response response = new Response();
        response.setResponseStr("response:");
        FilterChain fc = new FilterChain();
        fc.addFilter(new HTMLFilter()).addFilter(new SensitiveFilter()).addFilter(new FaceFilter());
        fc.doFilter(request,response,fc);
        System.out.println(request.getRequestStr());
        System.out.println(response.getResponseStr());

        HeaderTextProcessing p1 = new HeaderTextProcessing();
        SpellCheckerProcessing p2 = new SpellCheckerProcessing();
        p1.setSuccessor(p2);
        String result = p1.handleWork("Really Sexy");
        System.out.println(result);

    }
}
