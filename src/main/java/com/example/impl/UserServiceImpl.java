package com.example.impl;

import com.example.entity.PlayerInfo;
import com.example.entity.SendRecord;
import com.example.entity.User;
import com.example.mapper.PlayerInfoMapper;
import com.example.mapper.UserMapper;
import com.example.repository.LoginUserRepository;
import com.example.repository.SendRecordRepository;
import com.example.service.KafkaMessageService;
import com.example.service.RedisService;
import com.example.service.RedisToMySqlService;
import com.example.service.UserService;
import com.example.util.HttpUtil;
import com.google.gson.Gson;
import org.apache.tools.ant.Project;
import org.apache.tools.ant.taskdefs.SQLExec;
import org.apache.tools.ant.types.EnumeratedAttribute;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 登录用户实现类
 *
 * @author Tao
 */
@Service(value = "userService")
public class UserServiceImpl implements UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private LoginUserRepository loginUserRepository;

    @Autowired
    private SendRecordRepository sendRecordRepository;

    @Autowired
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    HttpServletRequest request;

    @Autowired
    private RedisToMySqlService redisToMySqlService;

    @Autowired
    private HttpUtil httpUtil;

    @Autowired
    KafkaMessageService kafkaMessageService;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private PlayerInfoMapper playerInfoMapper;



    @Override
    public void saveUser(String userName) {
        logger.info("测试数据------------>>" + userName);
        User user = new User();
        String ipAddr = httpUtil.getIpAddr(request);
        user.setUserIp(ipAddr);
        user.setUserName(userName);
        User save = loginUserRepository.save(user);
        System.out.println("--------保存后的id值---------" + save.getId());
        kafkaMessageService.sendKafkaMessage("HuKangKang", new Gson().toJson(user));
        System.out.println("kafka发送消息完毕");
    }

    @Override
    public List<User> findAllUser() {
        List<User> allUser = userMapper.findAllUser();
        return allUser;
    }

    /**
     * 100个线程同时读写数据库，若数据库为空，则插入一条数据，理论上数据库应该存在一条数据
     */

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void testReadAndWrite() {
        User user = new User();
        user.setUserName("tao");
        user.setUserIp("127.0.0.1");
        for (int i = 0; i < 100; i++) {
            threadPoolTaskExecutor.execute(() -> redisToMySqlService.readAndWriteDB(user));
        }
    }

    @Override
    public void testUpdate() {
        System.out.println("--------------------");
        List<User> userList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            User user1 = new User();
            User user2 = new User();
            user1.setId(249L);
            user1.setUserName("tao");
            user1.setUserIp(String.valueOf(i));

            user2.setId(250L);
            user2.setUserName("tao");
            user2.setUserIp(String.valueOf(i));
            userList.add(user1);
            userList.add(user2);
        }
        threadPoolTaskExecutor.execute(() -> updateDB(userList));

        System.out.println("更新完毕");
    }

    @Override
    public void testSelect() {
        List<PlayerInfo> playerInfos = playerInfoMapper.testPlayerInfo("孙爽", "Noxus");
        playerInfos.stream().forEach(x->{
            System.out.println(new Gson().toJson(x));
        });
    }

    /**
     * 线程中调用的是B接口的中方法，而不是本实现类中的方法
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public String testLockTable() {
        try {
            redisToMySqlService.lockTableTest();
            /*for (int i = 0; i < 1000; i++) {
                threadPoolTaskExecutor.execute(new Runnable() {
                    @Override
                    public void run() {
                        redisToMySqlService.lockTableTest();

                    }
                });
            }*/
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "正在处理中";
    }

    @Override
    public void testInsert() {
        try {
            String s = null;
            s.toString();
        } catch (Exception e) {
           logger.error("错误信息:",e);

        }
    }


    public static void main(String[] args) {
        SQLExec sqlExec = new SQLExec();
        sqlExec.setDriver("com.mysql.jdbc.Driver");
        sqlExec.setUrl("jdbc:mysql://localhost:3306/clearing?rewriteBatchedStatements=true&amp;useServerPrepStmts=false&amp;cachePrepStmts=true&amp;useCompression=true");
        sqlExec.setUserid("root");
        sqlExec.setPassword("");
        sqlExec.setSrc(new File("C:/Users/Tao/Desktop/t_trade_86663/t_trade.sql"));
        sqlExec.setOnerror((SQLExec.OnError) EnumeratedAttribute.getInstance(SQLExec.OnError.class,"abort"));
        sqlExec.setProject(new Project());
        sqlExec.execute();
    }

    private  void updateDB(List<User> userList) {
        String sql = "update t_user set user_name =?,user_ip=? where id =?";
        jdbcTemplate.batchUpdate(sql, userList, 100, (ps, u) -> {
            ps.setString(1, u.getUserName());
            ps.setString(2, u.getUserIp());
            ps.setLong(3, u.getId());
        });

    }
}
