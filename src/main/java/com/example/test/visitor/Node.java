package com.example.test.visitor;

public abstract class Node {
    public abstract void accept(Visitor visitor);
}
