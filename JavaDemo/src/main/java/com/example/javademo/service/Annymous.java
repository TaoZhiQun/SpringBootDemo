package com.example.javademo.service;

import java.util.ArrayList;
import java.util.List;

public class Annymous {
    public static void main(String[] args) {
        List<Goods> goodsList = new ArrayList<>();
        goodsList.add(new Goods() {
            @Override
            public boolean test(int i) {
                return 5-i>0;
            }
        });
        System.out.println(goodsList.get(0).test(3));
    }
}
