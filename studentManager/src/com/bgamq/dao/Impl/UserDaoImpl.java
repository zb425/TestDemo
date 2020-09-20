package com.bgamq.dao.Impl;


import com.bgamq.annotaion.Bean;
import com.bgamq.dao.UserDao;
import com.bgamq.entity.User;

import java.util.List;

@Bean
public class UserDaoImpl  implements UserDao {

    @Override
    public User findUserById(int id) {
        System.out.println("这是是findUserById");
        return null;
    }

    @Override
    public List<User> findAllUsers() {
        System.out.println("这是是findAllUsers");
        return null;
    }

    @Override
    public User findUsersByUserName() {
        System.out.println("这是是findUsersByUserName");
        return null;
    }

    @Override
    public void saveUser(User user) {
        System.out.println("这是是saveUser");
    }

}
