package com.bookManagementSystem.Server.impl;

import com.bookManagementSystem.Dao.BookMapper;
import com.bookManagementSystem.Entity.Book;
import com.bookManagementSystem.Server.BookServer;
import com.bookManagementSystem.Server.BorrowServer;
import com.bookManagementSystem.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class BookServerImpl implements BookServer {
    // 此方法是通过借阅列表将已借出去的图书和没借的区分开
    BorrowServerImpl borrowServer = new BorrowServerImpl();

    @Override
    public Map<Book, Boolean> getBookList() {
        Set<Integer> set = new HashSet<>();
        borrowServer.getBorrowList().forEach(borrow -> set.add(borrow.getBook_id()));
        try (SqlSession session = MybatisUtil.openSession(true)) {
            Map<Book, Boolean> map = new LinkedHashMap<>();
            BookMapper mapper = session.getMapper(BookMapper.class);
            mapper.getBookList().forEach(book -> map.put(book, set.contains(book.getBid())));
            return map;
        }
    }

    @Override
    public void deleteBook(int bid) {
        try (SqlSession session = MybatisUtil.openSession(true)) {
            BookMapper mapper = session.getMapper(BookMapper.class);
            mapper.deleteBook(bid);
        }
    }

    @Override
    public void addBook(String title, String desc, double price) {
        try (SqlSession session = MybatisUtil.openSession(true)) {
            BookMapper mapper = session.getMapper(BookMapper.class);
            mapper.addBook(title, desc, price);
        }
    }
}
