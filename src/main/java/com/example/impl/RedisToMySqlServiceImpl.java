package com.example.impl;

import com.example.entity.User;
import com.example.mapper.UserMapper;
import com.example.repository.LoginUserRepository;
import com.example.service.RedisToMySqlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Tao
 */
@Service
public class RedisToMySqlServiceImpl implements RedisToMySqlService {
    @Autowired
    private LoginUserRepository loginUserRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void readAndWriteDB(User user) {
        User findUser;
        try {
            findUser = loginUserRepository.findByUserNameAndUserIp(user.getUserName(), user.getUserIp());
            if (null == findUser) {
                userMapper.saveUser(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
