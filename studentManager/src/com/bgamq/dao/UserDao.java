package com.bgamq.dao;

import com.bgamq.entity.User;

import java.util.List;

public interface UserDao {

    /**
     * 根据id招到一个user
     * @param id
     * @return
     */
    User findUserById(int id);

    /**
     * 获取所有的用户
     * @return
     */
    List<User> findAllUsers();

    /**
     * 根据用户名获取用户
     * @return
     */
    User findUsersByUserName();

    /**
     * 保存用户
     * @param user
     */
    void saveUser(User user);
}
