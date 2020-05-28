package com.cn.wy.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="t_permission")
public class Permission {

    private String id;
    private String permissionName;
    private String permissionPid;
    private String permissionSrc;
    private String sort;

    @Id
    @Column(name = "ID")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(name = "PERMISSION_NAME")
    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    @Column(name = "PERMISSION_PID")
    public String getPermissionPid() {
        return permissionPid;
    }

    public void setPermissionPid(String permissionPid) {
        this.permissionPid = permissionPid;
    }

    @Column(name = "PERMISSION_SRC")
    public String getPermissionSrc() {
        return permissionSrc;
    }

    public void setPermissionSrc(String permissionSrc) {
        this.permissionSrc = permissionSrc;
    }

    @Column(name = "SORT")
    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }
}
