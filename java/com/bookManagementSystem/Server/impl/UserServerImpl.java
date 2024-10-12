package com.bookManagementSystem.Server.impl;

import com.bookManagementSystem.Dao.UserMapper;
import com.bookManagementSystem.Entity.User;
import com.bookManagementSystem.Server.UserServer;
import com.bookManagementSystem.utils.MybatisUtil;
import jakarta.servlet.http.HttpSession;
import org.apache.ibatis.session.SqlSession;

public class UserServerImpl implements UserServer {
    @Override
    public boolean isExit(String username, String password, HttpSession session) {
        try (SqlSession sqlSession = MybatisUtil.openSession(true)) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            User user = mapper.getUser(username, password);
            if (user == null) return false;
            session.setAttribute("user",user);
            return true;

        }

    }
}
