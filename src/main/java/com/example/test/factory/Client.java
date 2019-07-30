package com.example.test.factory;

public class Client {
    public static void main(String[] args) {
        String names[] = {"张三","李四","王五","Tao"};
        for(int i=0;i<8;i++){
            final Pencil pencil = PenFactory.get(names[i > 3 ? i - 4 : i]);
            pencil.setSomething("画了"+i);
            pencil.write();
        }
    }
}
