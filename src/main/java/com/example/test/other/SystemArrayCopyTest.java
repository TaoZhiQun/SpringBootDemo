package com.example.test.other;

import com.example.entity.User;

public class SystemArrayCopyTest {
    public static void main(String[] args) {
        User[] users = new User[]{new User("tao","11"),new User("chen","22")};
        User[] target = new User[users.length];
        System.arraycopy(users,0,target,0,users.length);
        System.out.println("数组里面的元素："+(users[0] == target[0]?"浅拷贝":"深拷贝"));
        System.out.println("数组本身："+(users == target?"浅拷贝":"深拷贝"));
    }
}
