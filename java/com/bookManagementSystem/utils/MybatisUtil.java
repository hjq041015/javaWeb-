package com.bookManagementSystem.utils;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MybatisUtil {
    private static SqlSessionFactory factory;
    static {
        try {
            factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static  SqlSession openSession(boolean autoCommit) {
        return factory.openSession(autoCommit);
    }
}


