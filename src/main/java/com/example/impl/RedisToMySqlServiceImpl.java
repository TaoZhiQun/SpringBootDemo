package com.example.impl;

import com.example.entity.User;
import com.example.mapper.UserMapper;
import com.example.repository.LoginUserRepository;
import com.example.service.RedisToMySqlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tao
 */
@Service
public class RedisToMySqlServiceImpl implements RedisToMySqlService {
    @Autowired
    private LoginUserRepository loginUserRepository;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void readAndWriteDB(User user) {
        User findUser;
        try {
            findUser = loginUserRepository.findByUserNameAndUserIp(user.getUserName(), user.getUserIp());
            List<User> userList = new ArrayList<>();
            if (null == findUser) {
                //userMapper.saveUser(user);
                String sql = "insert into t_user(user_name,user_ip) values(?,?)";
                jdbcTemplate.batchUpdate(sql,userList,1,(ps, t) ->{
                    ps.setString(1,t.getUserName());
                    ps.setString(2,t.getUserIp());
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
