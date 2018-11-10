package com.example.controller;

import com.example.entity.PlayerInfo;
import com.example.service.PlayerInfoService;
import com.example.service.UserService;
import com.example.util.Page;
import com.example.util.Pageable;
import com.example.util.PageableImpl;
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

    @Autowired
    private PlayerInfoService playerInfoService;
    @RequestMapping("/index")
    public String index(){
        return "userinfo";
    }

    /**
     *  测试多线程同时读写数据库，http://localhost:8089/testThread 即可进行测试
     */
    @RequestMapping("/testThread")
    @ResponseBody
    public void testThread(){
        userService.testReadAndWrite();
    }

    /**
     *  测试多线程同时更新数据库，http://localhost:8089/testUpdate 即可进行测试
     */
    @RequestMapping("/testUpdate")
    @ResponseBody
    public void testUpdate(){
        userService.testUpdate();
    }

    /**
     * 测试字段为String数组的mybatis查询
     */
    @RequestMapping("/testSelect")
    @ResponseBody
    public void testSelect(){
        userService.testSelect();
    }


    @RequestMapping("/searchPlayerInfo")
    @ResponseBody
    public Page<PlayerInfo> searchPlayerInfo(String playerName,String playerRegion,Integer pageNo,Integer pageSize){
        return playerInfoService.searchPlayerInfo(playerName,playerRegion,pageNo,pageSize);
    }



}
