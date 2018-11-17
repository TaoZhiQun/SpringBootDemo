package com.example.realm;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.HashSet;
import java.util.Set;

public class UserRealm extends AuthorizingRealm {
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("授权开始");
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        Set<String> perms=new HashSet<String>();
        Set<String> roles=new HashSet<String>();
        perms.add("/testUpdate");
        roles.add("user");
        simpleAuthorizationInfo.setStringPermissions(perms);
        simpleAuthorizationInfo.setRoles(roles);
        return simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("认证开始");
        try {
            UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
            String userName = token.getUsername();
            String password = String.valueOf(token.getPassword());

            if("admin".equals(userName)&&"123".equals(password)){
                return new SimpleAuthenticationInfo(token.getUsername(),
                        token.getPassword(), "standardRealm");
            }else{
                throw new AuthenticationException("wrong password");
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new AuthenticationException("wrong password");
        }
    }

}
