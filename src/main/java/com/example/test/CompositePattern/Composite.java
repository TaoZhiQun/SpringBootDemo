package com.example.test.CompositePattern;

import java.util.ArrayList;
import java.util.List;

public class Composite extends Component {
    private List<Component> children = new ArrayList<>();

    public Composite(String name) {
        super(name);
    }

    @Override
    public void add(Component c) {
        children.add(c);
    }

    @Override
    public void remove(Component c) {
        children.remove(c);
    }

    @Override
    public void display(int depth) {
        System.out.println("打印树节点"+depth);
        String temp = "";
        for (int i = 0; i < depth; i++) {
            temp += '-';
        }
        System.out.println(temp + name);
        for (Component c : children) {
            System.out.println(c instanceof Leaf);
            c.display(depth + 2);
        }
    }
}
