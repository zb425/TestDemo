package com.bgamq.service;

import com.bgamq.entity.Book;
import com.bgamq.entity.User;

public interface BookService {

    /**
     * 根据用户来借多本书
     * @param user
     * @param books
     */
    void borrow(User user, Book book);
}
