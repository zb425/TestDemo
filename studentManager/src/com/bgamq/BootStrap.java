package com.bgamq;

import com.bgamq.entity.Book;
import com.bgamq.entity.User;
import com.bgamq.reflect.ApplicationContext;
import com.bgamq.service.BookService;

public class BootStrap {
    public static void main(String[] args) {
        ApplicationContext<Object> context = new ApplicationContext<>();

        context.initContextByAnnotation();

        BookService bookService = (BookService)context.getBean(BookService.class);

        bookService.borrow(new User(),new Book());

    }
}
