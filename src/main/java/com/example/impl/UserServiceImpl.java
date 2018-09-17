package com.example.impl;

import com.example.entity.User;
import com.example.mapper.UserMapper;
import com.example.repository.LoginUserRepository;
import com.example.service.UserService;
import com.example.util.HttpUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 登录用户实现类
 * @author Tao
 */
@Service(value = "userService")
public class UserServiceImpl implements UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private LoginUserRepository loginUserRepository;

    @Autowired
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;

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
    @Transactional(rollbackFor = Exception.class)
    public void testReadAndWrite() {
        User user = new User();
        user.setUserName("tao");
        user.setUserIp("127.0.0.1");
        for(int i=0;i<100;i++){
            threadPoolTaskExecutor.execute(() -> readAndWriteDB(user));
        }
    }

     private  void readAndWriteDB(User user) {
        User findUser;
        try {
            findUser = loginUserRepository.findByUserNameAndUserIp(user.getUserName(),user.getUserIp());
            if(null == findUser){
                userMapper.saveUser(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private class ExtThreadFactory implements ThreadFactory {
        @Override
        public Thread newThread(Runnable r) {
            Thread newthread = new Thread(r);
            newthread.setName("wang" + new Date());
            newthread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
                @Override
                public void uncaughtException(Thread t, Throwable e) {
                    System.out.println("自定义处理异常" + t.getName() + e.getMessage());
                    e.printStackTrace();
                }
            });
            return newthread;
        }
    }
}
