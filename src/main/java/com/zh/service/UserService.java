package com.zh.service;

import com.zh.bean.User;
import java.util.List;

public interface UserService {

    /*
    * 保存用户对象
    * @param user
    * */
    void save(User user);

    /*
    * 获取所有用户对象
    * @return
    * */
    List<User> getUserList();

    /*
    * 删除对象
    * */
    void deleteUser(Long id);

    /*
    * 根据id获取一个对象
    * */
    User findOneUser(Long id);

    /*
    * 修改单个对象
    * */
    void updateOneUser(User user);

    /*
    * 查询单个用户信息 用于登录
    * */
    User findByNameAndPassword(String name, String password);
}
