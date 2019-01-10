package com.example.test.visitor;

import java.util.ArrayList;
import java.util.List;

public class ObjectStructure {
    private List<Node> nodes = new ArrayList<Node>();
    public void action(Visitor visitor){
        for(Node node:nodes){
            node.accept(visitor);
        }
    }

    public void add(Node node){
        nodes.add(node);
    }
}
