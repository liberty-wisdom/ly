package com.zh.dao;

import com.zh.bean.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends CommonDao<User>{

    User findByNameAndPassword(String name, String password);
}
