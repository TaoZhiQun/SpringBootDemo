package com.example.test.factory;

public class Pencil implements Pen {
    private String name;
    private String something;
    private int i;

    public Pencil(String name) {
        this.name = name;
        i++;
        System.out.println(name + "第：" + i + "次创建");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSomething() {
        return something;
    }

    public void setSomething(String something) {
        this.something = something;
    }

    @Override
    public void write() {
        System.out.println(name + "用铅笔画了" + something);
    }
}
