package com.example.test.observe;

import java.util.Observable;
import java.util.Observer;

/**
 * 观察者
 */
public class Tao implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        HuKangKang huKangKang= (HuKangKang)o;
        String context = huKangKang.getContext();
        System.out.println("Tao已经知道胡康康正在做"+context);
    }
}
