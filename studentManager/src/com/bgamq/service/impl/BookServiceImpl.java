package com.bgamq.service.impl;

import com.bgamq.annotaion.AutoWrid;
import com.bgamq.annotaion.Bean;
import com.bgamq.dao.BookDao;
import com.bgamq.dao.UserDao;
import com.bgamq.entity.Book;
import com.bgamq.entity.User;
import com.bgamq.service.BookService;

import java.util.List;

@Bean
public class BookServiceImpl implements BookService {

    @AutoWrid
    private UserDao userDao;

    @AutoWrid
    private BookDao bookDao;



    @Override
    public void borrow(User user, Book book) {

        List<User> allUsers = userDao.findAllUsers();




        System.out.println(user.getUsername()+"借" +book.getName());
    }
}
