package com.example.impl;

import com.example.entity.User;
import com.example.mapper.UserMapper;
import com.example.repository.LoginUserRepository;
import com.example.service.UserService;
import com.example.util.HttpUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service(value = "userService")
public class UserServiceImpl implements UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
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
        logger.info("测试数据------------>>"+userName);
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

    /**
     *  100个线程同时读写数据库，若数据库为空，则插入一条数据，理论上数据库应该存在一条数据
     */
    @Override
    public void testReadAndWrite() {
        ExecutorService executorService = Executors.newScheduledThreadPool(100);
        User user = new User();
        user.setUserName("tao");
        user.setUserIp("127.0.0.1");
        for(int i=0;i<1;i++){
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    readAndWriteDB(user);
                }
            });
        }
    }

    @Transactional
    private  void readAndWriteDB(User user) {
        User findUser = null;
        try {
            findUser = loginUserRepository.findByUserNameAndUserIp(user.getUserName(),user.getUserIp());
            if(null == findUser){
                userMapper.saveUser(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
