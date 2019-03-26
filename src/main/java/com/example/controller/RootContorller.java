package com.example.controller;

import com.example.config.RedisProperties;
import com.example.entity.Log;
import com.example.entity.MyEvent;
import com.example.entity.PlayerInfo;
import com.example.entity.User;
import com.example.service.PlayerInfoService;
import com.example.service.UserService;
import com.example.test.shiro.MyHttpSessionListener;
import com.example.util.Page;
import com.example.util.RedisLockMager;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.EventListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.net.URLEncoder;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.concurrent.TimeUnit;

/**
 * @author Tao 首页从此处进入，输入127.0.0.1:8080/index 即可跳转到index.jsp页面
 */
@Controller
@RequestMapping("/root")
public class RootContorller {
    @Autowired
    private UserService userService;

    @Autowired
    private RedisLockMager redisLockMager;

    @Autowired
    private PlayerInfoService playerInfoService;

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @Autowired
    private RedisProperties redisProperties;

    @Autowired
    ApplicationContext applicationContext;

    @RequestMapping("/index")
    public String index() {
        return "/userinfo/userinfo";
    }

    /**
     * 测试多线程同时读写数据库，http://localhost:8089/testThread 即可进行测试
     */
    @RequestMapping("/testThread")
    @ResponseBody
    public void testThread() {
        userService.testReadAndWrite();
    }

    /**
     * 测试多线程同时更新数据库，http://localhost:8089/testUpdate 即可进行测试
     */
    @RequestMapping("/testUpdate")
    @ResponseBody
    public void testUpdate() {
        userService.testUpdate();
    }

    @PostMapping("/Login")
    public void getUserByUserNameAndPassword(String username, String password, HttpSession session) {
        session.setAttribute(username,password);
    }

    /**
     * 测试字段为String数组的mybatis查询
     */
    @RequestMapping("/online")
    @ResponseBody
    public void online() {
        System.out.println( "当前在线人数：" + MyHttpSessionListener.online + "人");
    }

    /**
     * 测试字段为String数组的mybatis查询
     */
    @RequestMapping("/testSelect")
    @ResponseBody
    public void testSelect() {
        userService.testSelect();
    }

    /**
     * 测试锁表
     */
    @RequestMapping("/testLockTable")
    @ResponseBody
    public String testLockTable() {
        return userService.testLockTable();
    }

    @RequestMapping("/Logout")
    @ResponseBody
    public String Logout(HttpServletRequest request,String username){
        HttpSession session = request.getSession(false);
        if(null != session){
            session.removeAttribute(username);
            session.invalidate();
        }
        return "退出登录成功";
    }



    @RequestMapping("/searchPlayerInfo")
    @ResponseBody
    public Page<PlayerInfo> searchPlayerInfo(String playerName, String playerRegion, Integer pageNo, Integer pageSize) {
        System.out.println("进入查询链接");
        return playerInfoService.searchPlayerInfo(playerName, playerRegion, pageNo, pageSize);
    }


    @RequestMapping("/exportPlayerInfo")
    @ResponseBody
    public void exportPlayerInfo(String playerName, String playerRegion, HttpServletResponse response) {
        try {
            //先加入测试
            InputStream in = new FileInputStream(new File("c://1.xls"));
            response.setContentType("application/vnd.ms-excel");
            response.setHeader("Content_Length", String.valueOf(in.available()));
            response.setHeader("Content-disposition", "attachment; filename=" + URLEncoder.encode("taozhiqun.xls", "utf-8"));
            response.setHeader("error_code", "200");

            byte[] bytes = new byte[1024];
            int len;
            while ((len = in.read(bytes)) != -1) {
                response.getOutputStream().write(bytes, 0, len);
                response.flushBuffer();
            }
            response.flushBuffer();
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("playerName" + playerName);
    }

    @RequestMapping("/testRedisWithLock")
    @ResponseBody
    public void testRedisWithLock(String key) {
        try {
            if (redisLockMager.tryLock("CHEN", "bao", 500, TimeUnit.SECONDS)) {
                System.out.println("------------任务处理完毕,当前key------------" + key + "系统日期" + LocalDate.now() + "时间为" + LocalTime.now());
                kafkaTemplate.send(key, 0, key);
            } else {
                testRedisWithLock(key);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            redisLockMager.unLock("chen");
        }
    }

    @RequestMapping("/save")
    @ResponseBody
    public void save(){
        userService.testInsert();
    }

    @RequestMapping("/testRedis")
    @ResponseBody
    public void testRedis(String key) {
        String clusterNoede = redisProperties.getClusterNodes();
        int commandTimeout = redisProperties.getCommandTimeout();
        int expireSeconds = redisProperties.getExpireSeconds();
        System.out.println("集群节点"+clusterNoede);
        System.out.println("超时时间"+commandTimeout);
        System.out.println("过期时间"+expireSeconds);

    }


    @PostMapping(value = "/insertlog")
    @ResponseBody
    public void insertLog(@RequestBody Log log) {
        System.out.println(new Gson().toJson(log));
    }


    @RequestMapping("/testevent")
    @ResponseBody

    public void testEvent() {
        MyEvent myEvent = new MyEvent();
        myEvent.setData("登录成功，发布成功事件");
        applicationContext.publishEvent(myEvent);
    }

    @EventListener
    @Async
    public void loginOutReceive(MyEvent event) {
        System.out.println(Thread.currentThread().getName() + "接收到登出成功事件:" + event.getData());
    }


}
