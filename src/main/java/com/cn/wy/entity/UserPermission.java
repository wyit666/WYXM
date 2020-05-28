package com.cn.wy.entity;

import javax.persistence.*;

@Entity
@Table(name="t_user_permission")
public class UserPermission {

    private String id;
    private String userId;
    private String permissionId;

    @Id
    @Column(name = "ID", nullable = true)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "USER_ID", nullable = true)
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "PERMISSION_ID", nullable = true)
    public String getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId;
    }
}
