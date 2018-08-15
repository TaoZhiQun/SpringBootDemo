package com.example.impl;

import com.example.entity.User;
import com.example.mapper.UserMapper;
import com.example.repository.LoginUserRepository;
import com.example.service.UserService;
import com.example.util.HttpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service(value = "userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private LoginUserRepository loginUserRepository;

    @Autowired
    private UserMapper userMapper;
    @Autowired
    HttpServletRequest request;
    @Autowired
    private HttpUtil httpUtil;
    @Override
    public void saveUser(String userName) {
        User user = new User();
        String ipAddr = httpUtil.getIpAddr(request);
        user.setUserIp(ipAddr);
        user.setUserName(userName);
        loginUserRepository.save(user);
    }

    @Override
    public List<User> findAllUser() {
        List<User> allUser = userMapper.findAllUser();
        return allUser;
    }
}
