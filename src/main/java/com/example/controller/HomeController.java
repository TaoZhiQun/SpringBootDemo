package com.example.controller;

import com.example.entity.User;
import com.example.mapper.UserMapper;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author Tao
 * 跳转到登录成功后的页面
 */
@Controller
@RequestMapping("/home")
public class HomeController {
    @Autowired
    private UserService userService;
    @RequestMapping("/login")
    public ModelAndView login(String userName){
        ModelAndView modelAndView = modelAndView = new ModelAndView("/home/login");
        userService.saveUser(userName);
        List<User> allUser = userService.findAllUser();
        modelAndView.addObject("userName",userName);
        modelAndView.addObject("allUser",allUser);
        return modelAndView;
    }
}
