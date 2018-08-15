package com.example.mapper;

import com.example.entity.User;

import java.util.List;

public interface UserMapper {
    /**
     * 返回全部用户
     * @return
     */
    List<User> findAllUser();
}
