package com.cn.wy.service.impl.service;

import java.util.Map;

public interface LoginService {
    //用户登录
    Map<String,Object> Login(String userCode, String userPassword);
}
