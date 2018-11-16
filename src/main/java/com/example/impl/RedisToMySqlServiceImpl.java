package com.example.impl;

import com.example.entity.SendRecord;
import com.example.entity.User;
import com.example.mapper.UserMapper;
import com.example.repository.LoginUserRepository;
import com.example.repository.SendRecordRepository;
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

    @Autowired
    private SendRecordRepository sendRecordRepository;


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

    /**
     *  测试锁表使用方法，数据库为mysql 5.5 innodb
     *  1：在表数据量为一千万的情况下，10个线程同时进行删除、插入操作（插入与删除数据量均很大），直接发生锁表
     *  2：在表数据只有10条的情况下，100线程同时进行删除、插入操作不会造成锁表，但1000个线程时，会发生获取不到有效的连接
     *  3：在加入索引的情况下，无论是100个线程或1000个线程，同时进行均不会造成锁表
     *  4：在多线程中加入事务，线程中调用的方法必须是另个一个接口中的方法，否则会报找不到事务管理器，例如在实现类A中线程调用test()方法，test方法必须
     *  放到另外一个接口中
     *  发生锁表原理：在一个事务中先删后插，通过条件去删除记录，如果条件在数据库中存在，则产生行锁，先锁后删再释放
     *  若记录不存在，扫描索引，当记录不存在时，delete将获得间隙锁，没有索引极容易锁表造成锁等待超时
     */

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void lockTableTest() {
        List<SendRecord> sendRecordList = sendRecordRepository.findByGiftIdAndToUserId("tao", "2");
        sendRecordRepository.deleteByGiftIdAndToUserId("tao", "2");
        sendRecordRepository.save(sendRecordList);
    }
}
