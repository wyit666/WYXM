package com.cn.wy.controller;

import com.cn.wy.service.impl.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    @ResponseBody
    public Map<String, Object> Login(String userCode, String userPassword){
        Map<String, Object> map = new HashMap<>();
        try {
            map = loginService.Login(userCode, userPassword);
        }catch (Exception e){
            System.out.println(e);
        }
        return map;
    }

}
