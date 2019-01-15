package com.example.util;

import java.net.UnknownHostException;

public class NetworkUtil {
    public static String getHostName(){
        try {
            return java.net.InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            return java.net.InetAddress.getLoopbackAddress().getHostAddress();
        }
    }
    public static void main(String[] args) {
        System.out.println(getHostName());
    }
}
