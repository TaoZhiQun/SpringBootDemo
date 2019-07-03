package com.example.test.callback;

import java.util.stream.Stream;

public class Client {
    public static void main(String[] args) {
        Callback callback =()-> System.out.println("处理完的回调");
        Listener listener = new Listener();
        listener.execute(callback);

        final Stream<Integer> stream = Stream.iterate(1, x -> x + 1).limit(100);
        final Integer sum = stream.reduce(0, (x, y) -> x + y);
        System.out.println(sum);
    }
}
