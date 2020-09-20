package com.bgamq.dao;

import com.bgamq.entity.Book;
import com.bgamq.entity.User;

import java.util.List;

public interface BookDao {

    /**
     * 根据id招到一个Book
     * @param id
     * @return
     */
    User findBookById(int id);

    /**
     * 获取所有的Book
     * @return
     */
    List<Book> findAllBooks();


}
