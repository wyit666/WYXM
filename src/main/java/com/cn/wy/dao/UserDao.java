package com.cn.wy.dao;

import com.cn.wy.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserDao extends JpaRepository<User, String>, JpaSpecificationExecutor<User> {

    @Query(value = "from User t where t.userCode=:userCode and t.userPassWord=:userPassWord")
    User findUserByCodeAndPaw(@Param("userCode") String userCode, @Param("userPassWord") String userPassword);
}
