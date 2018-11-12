package com.example.controller;

import com.example.entity.User;
import com.example.mapper.UserMapper;
import com.example.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String login(String userName,String password,Model model){
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(userName, password);
        try {
            subject.login(usernamePasswordToken);
        } catch (AuthenticationException e) {
            model.addAttribute("msg","登录失败");
            return "redirect:toLogin";
        }
        model.addAttribute("msg","登录成功");
        return "login/succeed";
    }

    @RequestMapping("/toLogin")
    public ModelAndView toLogin(){
        ModelAndView modelAndView = new ModelAndView("login");
        return modelAndView;
    }
}
