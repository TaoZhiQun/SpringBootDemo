package com.example.test.other;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.Comparator.comparingLong;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toCollection;

class Person{
    private long id;
    private String name;

    public Person(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
        Person p1 = new Person(1,"tao");
        Person p2  = new Person(1,"zhang");
        personList.add(p1);
        personList.add(p2);

        List<Person> distinctList =personList.stream()
                  .filter(distinctByKey(x->x.getId()))
                  .collect(Collectors.toList());

        System.out.println(Arrays.asList(distinctList));
    }
    public static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor) {
        Map<Object, Boolean> seen = new ConcurrentHashMap<>();
        return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }

}
