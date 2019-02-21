package com.example.entity;

public class MyEvent<T>  {
    private T data;
    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
