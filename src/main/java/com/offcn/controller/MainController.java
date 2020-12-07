package com.offcn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    @RequestMapping("toMain.do")
    public String toMain(){
        return "main";
    }

    @RequestMapping("list.do")
    public String toList(){
        return "list";
    }
}
