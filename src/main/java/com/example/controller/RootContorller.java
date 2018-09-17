package com.example.controller;

import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Tao 首页从此处进入，输入127.0.0.1:8080/index 即可跳转到index.jsp页面
 */
@Controller
public class RootContorller {
    @Autowired
    private UserService userService;
    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    /**
     *  测试多线程同时读写数据库，http://localhost:8080/testThread 即可进行测试
     */
    @RequestMapping("/testThread")
    @ResponseBody
    public void testThread(){
        userService.testReadAndWrite();
    }
}
