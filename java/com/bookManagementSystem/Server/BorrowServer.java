package com.bookManagementSystem.Server;

import com.bookManagementSystem.Entity.Book;
import com.bookManagementSystem.Entity.Borrow;

import java.util.List;

public interface BorrowServer {
    List<Borrow> getBorrowList();
    void deleteBorrow(String id);
    List<Book> getActiveBookList();
    void addBorrow(int sid , int bid);
}
