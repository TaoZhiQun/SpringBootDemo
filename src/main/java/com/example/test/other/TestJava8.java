package com.example.test.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
class Shop{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Shop(String name) {
        this.name = name;
    }
}

public class TestJava8 {
    public static void main(String[] args) {
        List<String> alpha = Arrays.asList("a","b","c","d");
        List<String> alphaUpper = new ArrayList<>();
        for(String s:alpha){
            alphaUpper.add(s.toUpperCase());
        }
        System.out.println(alpha);
        System.out.println(alphaUpper);

        List<String> collect = alpha.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(collect);

        List<Integer> num = Arrays.asList(1,2,3,4,5);
        List<Integer> collect1 = num.stream().map(n -> n + 2).collect(Collectors.toList());
        System.out.println(collect1);

        Integer reduce = num.stream().reduce(0,(a, b) -> a + b);
        System.out.println(reduce);

        List<String> bestPrice = findPrices("BestPrice");
        System.out.println(Arrays.asList(bestPrice));



    }

    public static List<String> findPrices(String product){
        List<Shop> shops = Arrays.asList(new Shop("BestPrice"),new Shop("LetsSave"),new Shop("BuyItAll"));
        List<CompletableFuture<String>> futures = shops.stream().map(shop -> CompletableFuture.supplyAsync(() -> "名称为"+shop.getName())).collect(Collectors.toList());
        return futures.stream().map(CompletableFuture::join).collect(Collectors.toList());
    }



}
