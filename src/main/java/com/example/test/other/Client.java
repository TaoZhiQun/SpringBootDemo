package com.example.test.other;


public class Client {
    public static void main(String[] args)  {
        SecurityManager securityManager = System.getSecurityManager();
        System.out.println(securityManager);
    }
}
