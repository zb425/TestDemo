package com.bgamq.service.impl;

import com.bgamq.annotation.AutoWrid;
import com.bgamq.annotation.Bean;
import com.bgamq.dao.Impl.UserDaoImpl;
import com.bgamq.dao.UserDao;
import com.bgamq.service.UserService;

@Bean
public class UserServiceImpl implements UserService {

   /* @AutoWrid
    private UserDao userDao;*/

    @Override
    public void login() {
        System.out.println("这是登录业务实现方法");
    }

    @Override
    public void regist() {
        System.out.println("这是注册实现方法");
    }
}
