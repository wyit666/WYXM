package com.cn.wy.service.impl.service.impl;

import com.cn.wy.dao.LoginDao;
import com.cn.wy.entity.User;
import com.cn.wy.service.impl.service.LoginService;
import com.cn.wy.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service
@Transactional
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginDao loginDao;

    /**
     * 用户登录
     */
    @Override
    public Map<String, Object> Login(String userCode, String userPassword) {
        Map<String, Object> map = new HashMap<>();
        try {
            if(StringUtil.isNotEmpty(userCode) && StringUtil.isNotEmpty(userPassword)){
                User user = loginDao.findUserByCodeAndPaw(userCode, userPassword);
                if(user!=null){
                    map.put("data", user);
                    map.put("return", "登录成功!");
                    map.put("success", "true");
                }else{
                    map.put("data", "");
                    map.put("return", "账号不存在或密码不正确!");
                    map.put("success", "false");
                }
            }else{
                map.put("data", "");
                map.put("return", "请输入账号或密码!");
                map.put("success", "false");
            }
        }catch (Exception e){
            map.put("data", "");
            map.put("return", "系统异常!");
            map.put("success", "false");
            System.out.println(e);
        }
        return map;
    }
}
