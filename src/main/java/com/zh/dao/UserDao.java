package com.zh.dao;

import com.zh.bean.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends CommonDao<User>{
    //查询用户，用作登录
    User findByNameAndPassword(String name, String password);
}
