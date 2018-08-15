package com.example.service;

import com.example.entity.User;

import java.util.List;

public interface UserService {
    /**
     * 保存用户信息
     * @param userName
     */
    void saveUser(String userName);

    /**
     *  查询全部用户
     * @return
     */
    List<User> findAllUser();
}
