package com.bookManagementSystem.Server.impl;

import com.bookManagementSystem.Dao.BookMapper;
import com.bookManagementSystem.Dao.borrowMapper;
import com.bookManagementSystem.Entity.Book;
import com.bookManagementSystem.Entity.Borrow;
import com.bookManagementSystem.Server.BorrowServer;
import com.bookManagementSystem.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;


import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class BorrowServerImpl implements BorrowServer {
    @Override
    public List<Borrow> getBorrowList() {
        try (SqlSession session = MybatisUtil.openSession(true)) {
            borrowMapper mapper = session.getMapper(borrowMapper.class);
            return mapper.getBorrowList();
        }
    }

    @Override
    public void deleteBorrow(String id) {
        try (SqlSession session = MybatisUtil.openSession(true)) {
            borrowMapper mapper = session.getMapper(borrowMapper.class);
            mapper.deleteBorrow(id);
        }
    }


    // 此方法是过滤掉已经被借走的书,通过在set里存入已经被借走书的id,然后利用stream过滤没被借走的书,将没被借走的书存入List中
    @Override
    public List<Book> getActiveBookList() {
        Set<Integer> set = new HashSet<>();
        this.getBorrowList().forEach(borrow -> set.add(borrow.getBook_id()));
        try (SqlSession session = MybatisUtil.openSession(true)) {
            BookMapper mapper = session.getMapper(BookMapper.class);
            return mapper.getBookList()
                    .stream()
                    .filter(book -> !set.contains(book.getBid()))
                    .collect(Collectors.toList());
        }
    }

    @Override
    public void addBorrow(int sid, int bid) {
        try (SqlSession session = MybatisUtil.openSession(true)) {
            borrowMapper mapper = session.getMapper(borrowMapper.class);
            mapper.addBorrow(sid, bid);
        }


    }
}
