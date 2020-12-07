package com.offcn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @RequestMapping("login.do")
    public String login(String username, String password, HttpSession session){
        System.out.println(username + "---" + password);
        //假设登录成功   把用户信息放入session
        session.setAttribute("username",username);
        return "main";
    }
}
