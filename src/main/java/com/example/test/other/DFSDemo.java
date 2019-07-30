package com.example.test.other;

public class DFSDemo {
    int[] num = new int[3];

    public void dfs(int index) {
        if (index == 3) {
            for (int i = 0; i < 3; i++) {
                System.out.print(num[i] + " ");
            }
            System.out.println();
            return;
        }
        for (int i = 1; i <= 3; i++) {
            num[index] =i;
            dfs(index+1);
        }
    }

    public static void main(String[] args) {
        DFSDemo dfsDemo = new DFSDemo();
        dfsDemo.dfs(0);
    }
}
