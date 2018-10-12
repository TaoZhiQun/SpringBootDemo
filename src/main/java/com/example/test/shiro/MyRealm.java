package com.example.test.shiro;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.HashSet;
import java.util.Set;

public class MyRealm extends AuthorizingRealm {
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("---------------授权开始--------------");
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        // 权限
        Set<String> permissions = new HashSet<>();
        permissions.add("printer:print");
        permissions.add("printer:query");
        simpleAuthorizationInfo.setStringPermissions(permissions);
        // 角色
        Set<String> roles = new HashSet<String>();
        roles.add("role1");
        simpleAuthorizationInfo.setRoles(roles);
        return simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username = (String)authenticationToken.getPrincipal();
        String password = new String((char[]) authenticationToken.getCredentials());
        if(!"admin".equals(username)){
            throw  new UnknownAccountException();
        }
        if(!"123".equals(password)){
            throw  new IncorrectCredentialsException();
        }
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(username, password, getName());
        return simpleAuthenticationInfo;
    }
}
