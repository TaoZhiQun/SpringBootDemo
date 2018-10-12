package com.example.test.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;

public class TestShiro {
    public static void main(String[] args) {
        SecurityManager securityManager = new IniSecurityManagerFactory("classpath:shiro-realm.ini").getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        Subject currentUser = SecurityUtils.getSubject();
        if(!currentUser.isAuthenticated()){
            UsernamePasswordToken token = new UsernamePasswordToken("admin", "123");
            token.setRememberMe(false);
            currentUser.login(token);
        }
        if(currentUser.isAuthenticated()){
            currentUser.logout();
            System.out.println("---------登录成功-----------");
        }
        System.out.println(currentUser.getSession());
    }
}
