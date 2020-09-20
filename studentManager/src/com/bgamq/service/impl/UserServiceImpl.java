package com.bgamq.service.impl;


import com.bgamq.annotaion.Bean;
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
