package com.cn.wy.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="t_user")
public class User {

    private String id;
    private String userName;
    private String userSex;
    private String userIdentity;
    private String userPhone;
    private String userCode;
    private String userPassWord;

    @Id
    @Column(name = "ID")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "USER_NAME", nullable = true)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name="USER_SEX", nullable = true)
    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    @Basic
    @Column(name="USER_IDENTITY", nullable = true)
    public String getUserIdentity() {
        return userIdentity;
    }

    public void setUserIdentity(String userIdentity) {
        this.userIdentity = userIdentity;
    }

    @Basic
    @Column(name="USER_PHONE", nullable = true)
    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    @Basic
    @Column(name="USER_CODE", nullable = true)
    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    @Column(name="USER_PASSWORD", nullable = true)
    public String getUserPassWord() {
        return userPassWord;
    }

    public void setUserPassWord(String userPassWord) {
        this.userPassWord = userPassWord;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(userName, user.userName) &&
                Objects.equals(userSex, user.userSex) &&
                Objects.equals(userIdentity, user.userIdentity) &&
                Objects.equals(userPhone, user.userPhone) &&
                Objects.equals(userCode, user.userCode) &&
                Objects.equals(userPassWord, user.userPassWord);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, userName, userSex, userIdentity, userPhone, userCode, userPassWord);
    }
}
