package com.cn.wy.service;

import com.cn.wy.entity.Permission;

import java.util.List;

public interface JspService {

    List<Permission> selUserPermission(String userId);
}
