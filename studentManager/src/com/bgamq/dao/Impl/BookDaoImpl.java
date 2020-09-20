package com.bgamq.dao.Impl;


import com.bgamq.annotaion.Bean;
import com.bgamq.dao.BookDao;
import com.bgamq.entity.Book;
import com.bgamq.entity.User;

import java.util.List;

@Bean
public class BookDaoImpl implements BookDao {
    @Override
    public User findBookById(int id) {
        System.out.println("这是findBookById");
        return null;
    }

    @Override
    public List<Book> findAllBooks() {
        System.out.println("这是findBookById");
        return null;
    }
}
