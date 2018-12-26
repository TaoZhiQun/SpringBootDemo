package com.example.test.other;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Apple {
    private String name;
    private String weight;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }
}

public class TestGson {
    public static void main(String[] args) {
        List<Apple> appleList = new ArrayList<>();
        Apple apple1 = new Apple();
        apple1.setName("red");
        apple1.setWeight("28");
        Apple apple2 = new Apple();
        apple2.setName("red");
        apple2.setWeight("29");
        appleList.add(apple1);
        appleList.add(apple2);

        Map<String, String> collect = appleList.stream().collect(Collectors.toMap(Apple::getName, Apple::getWeight, (key1, key2) -> key2));
        System.out.println(collect);

    }
}
