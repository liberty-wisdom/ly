package com.zh.service.impl;

import com.zh.bean.User;
import com.zh.dao.UserDao;
import com.zh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    public List<User> getUserList() {
        return userDao.findAll();
    }

    @Override
    public void deleteUser(Long id) {
        userDao.deleteById(id);
    }

    @Override
    public User findOneUser(Long id) {

        return userDao.getOne(id);
    }

    @Override
    public void updateOneUser(User user) {
        userDao.save(user);
    }

    @Override
//    @Modifying  修改时添加此注解，否则报错
    @Query("select name,password from user where name=?1 and password =?2")
    public User findByNameAndPassword(String name, String password) {

        return userDao.findByNameAndPassword(name,password);
    }

}
