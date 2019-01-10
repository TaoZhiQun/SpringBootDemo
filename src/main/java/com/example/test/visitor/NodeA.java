package com.example.test.visitor;

public class NodeA extends Node {

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public String operationA(){
        return "NodeA";
    }

}
