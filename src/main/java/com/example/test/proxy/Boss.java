package com.example.test.proxy;

public class Boss {
    private String name;

    public Boss(String name) {
        this.name = name;
    }
    void ok(){
        System.out.println(name+"说:我觉得ok");
    }
    void notOk(){
        System.out.println(name+"说:我觉得不行");
    }
}
