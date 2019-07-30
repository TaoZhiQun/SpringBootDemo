package com.example.test.other;

public class RecurDemo {
    public static void main(String[] args) {
        int sum = f(2);
        System.out.println(sum);
    }
    public static int f(int a){
        if(a<=1){
            return a;
        }
        return f(a-1)+ f(a-2);
    }

}
