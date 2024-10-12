package com.bookManagementSystem.Server;

import com.bookManagementSystem.Entity.Book;

import java.util.Map;

public interface BookServer {
    Map<Book , Boolean> getBookList();
    void deleteBook(int bid);
    void addBook(String title , String desc, double price);
}
