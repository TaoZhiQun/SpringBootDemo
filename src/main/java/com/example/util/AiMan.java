package com.example.util;

import java.util.Scanner;

public class AiMan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String sc;
        while (true){
            sc = scanner.next();
            sc = sc.replace('吗',' ');
            sc = sc.replace('?','!');
            sc = sc.replace('？','!');
            System.out.println(sc);
        }

    }
}
