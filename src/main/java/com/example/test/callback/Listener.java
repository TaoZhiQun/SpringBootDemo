package com.example.test.callback;

public class Listener {
    public void execute(Callback callback){
        System.out.println("在这里调用方法处理完其它事情");
        callback.call();
    }
}
