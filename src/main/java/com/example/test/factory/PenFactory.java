package com.example.test.factory;

import java.util.HashMap;
import java.util.Map;

public class PenFactory {
    private static final Map<String,Pencil> map = new HashMap<String,Pencil>();
    public static Pencil get(String name){
         Pencil pencil = map.get(name);
        if(pencil == null){
            pencil = new Pencil(name);
            map.put(name,pencil);
        }
        return pencil;
    }
}
