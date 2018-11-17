package com.example.test.other;

import java.util.*;
import java.util.stream.Collectors;

class Person {
    private Long id;
    private String name;

    public Person(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

public class DistinctDemo {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        Person p1 = new Person(1L, "tao");
        Person p2 = new Person(1L, "zhi");
        Person p3 = new Person(1L, "qun");
        Person p4 = new Person(1L, "hello");
        personList.add(p1);
        personList.add(p2);
        personList.add(p3);
        personList.add(p4);

        // 根据id去重
        // list去重  取最后一个（list转map）
        Map<Long, Person> personMap = personList.stream().collect(Collectors.toMap(Person::getId, x -> x, (key1, key2) -> key2));
        List<Person> distinctList = personMap.values().stream().collect(Collectors.toList());
        System.out.println("去重后取最后一个"+Arrays.asList(distinctList));

        // list去重 取第一个
        ArrayList<Person> personArrayList = personList.stream().
                collect(Collectors.collectingAndThen(Collectors.toCollection(() -> new TreeSet<>( Comparator.comparing(Person::getId))), ArrayList::new));
        System.out.println("去重后取第一个"+Arrays.asList(personArrayList));
    }

}
