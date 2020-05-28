package com.cn.wy.service.impl.service.impl;

import com.cn.wy.entity.Permission;
import com.cn.wy.entity.User;
import com.cn.wy.service.impl.service.JspService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;

@Service
@Transactional
public class JspServiceImpl implements JspService {

    @Autowired
    private HttpServletRequest request;
    /*@Autowired
    private PermissionDao permissionDao;*/

    @Override
    public Permission selUserPermission() {
        Permission permission = new Permission();
        try {
            User user = (User) request.getAttribute("user");
            if(user!=null){
                //permission = permissionDao.findByUserId(user.getId());
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return permission;
    }
}
