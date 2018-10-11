package com.example.service;

import com.example.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
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


    void testReadAndWrite();


}
