package com.example.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

class Person{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

public class SingleteonTest {

    private String member;
    private Map<String,Person> personMap;
    public Map<String, Person> getPersonMap() {
        return personMap;
    }
    public void setPersonMap(Map<String, Person> personMap) {this.personMap = personMap;
    }

    private SingleteonTest(String member){this.member = member;}

    private static List<SingleteonTest> singleList = new CopyOnWriteArrayList<>();

    public static synchronized SingleteonTest getInstance(String member){
        for(SingleteonTest singleteonTest:singleList){
            if(singleteonTest.member.equals(member)){
                return singleteonTest;
            }
        }
        SingleteonTest test = new SingleteonTest(member);
        singleList.add(test);
        return test;
    }
    public static void main(String[] args) {
        Person tao = new Person();
        tao.setName("tao");
        Map<String,Person> taoPersonMap= new HashMap<>();
        taoPersonMap.put("tao",tao);

        Person chen = new Person();
        chen.setName("chen");
        Map<String,Person> chenPersonMap= new HashMap<>();
        chenPersonMap.put("chen",chen);

        SingleteonTest.getInstance("tao").setPersonMap(taoPersonMap);
        SingleteonTest.getInstance("chen").setPersonMap(chenPersonMap);

        System.out.println(SingleteonTest.getInstance("tao").getPersonMap().get("tao").getName());
        System.out.println(SingleteonTest.getInstance("chen").getPersonMap().get("chen").getName());

    }
}
