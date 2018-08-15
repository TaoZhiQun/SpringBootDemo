package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Tao 首页从此处进入，输入127.0.0.1:8080/index 即可跳转到index.jsp页面
 */
@Controller
public class RootContorller {
    @RequestMapping("/index")
    public String index(){
        return "index";
    }
}
