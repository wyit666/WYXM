package com.cn.wy.service.impl;

import com.cn.wy.dao.PermissionDao;
import com.cn.wy.entity.Permission;
import com.cn.wy.entity.User;
import com.cn.wy.service.JspService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class JspServiceImpl implements JspService {

    @Autowired
    private PermissionDao permissionDao;

    @Override
    public List<Permission> selUserPermission(String userId) {
        List<Permission> permissions = new ArrayList<>();
        List<Permission> permissionList = new ArrayList<>();
        try {
            String sql = "select p.* from t_user_permission up " +
                    "left join t_permission p on up.permission_id = p.id " +
                    "where up.user_id =?0 order by p.sort";
            permissions = permissionDao.findListBySql(sql, userId);
            permissionList = treeMenuList(permissions, "0");
        }catch (Exception e){
            System.out.println(e);
        }
        return permissionList;
    }

    public List<Permission> treeMenuList(List<Permission> menuList, String parentId) {
        List<Permission> childMenu = new ArrayList();
        for (int i = 0; i < menuList.size(); i++) {
            Permission permission = new Permission();
            permission = menuList.get(i);
            if (parentId.equals(menuList.get(i).getPermissionPid())) {
                List<Permission> childList = treeMenuList(menuList, menuList.get(i).getId());
                permission.setChildrens(childList);
                childMenu.add(permission);
            }
        }
        return childMenu;
    }
}
