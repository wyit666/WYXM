package com.cn.wy.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="t_permission")
public class Permission implements Serializable {

    private String id;
    private String permissionName;
    private String permissionPid;
    private String permissionSrc;
    private String sort;

    private List<Permission> Childrens = new ArrayList<>();

    @Id
    @Column(name = "ID", nullable = true)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "PERMISSION_NAME", nullable = true)
    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    @Basic
    @Column(name = "PERMISSION_PID", nullable = true)
    public String getPermissionPid() {
        return permissionPid;
    }

    public void setPermissionPid(String permissionPid) {
        this.permissionPid = permissionPid;
    }

    @Basic
    @Column(name = "PERMISSION_SRC", nullable = true)
    public String getPermissionSrc() {
        return permissionSrc;
    }

    public void setPermissionSrc(String permissionSrc) {
        this.permissionSrc = permissionSrc;
    }

    @Basic
    @Column(name = "SORT", nullable = true)
    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    @Transient
    public List<Permission> getChildrens() {
        return Childrens;
    }

    public void setChildrens(List<Permission> childrens) {
        Childrens = childrens;
    }
}
