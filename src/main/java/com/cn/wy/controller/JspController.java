package com.cn.wy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/jsp")
public class JspController {

    @GetMapping("/login")
    public String Login(){
        return "login";
    }

    @GetMapping("/index")
    public String Index(){
        return "view/index";
    }

    @GetMapping("/head")
    public String Head(){
        return "view/head";
    }

    @GetMapping("/left")
    public String Left(){
        return "view/left";
    }

    @GetMapping("/main")
    public String Main(){
        return "view/main";
    }
}
