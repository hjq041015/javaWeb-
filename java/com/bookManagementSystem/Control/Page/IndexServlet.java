package com.bookManagementSystem.Control.Page;

import com.bookManagementSystem.Entity.User;
import com.bookManagementSystem.Server.BookServer;
import com.bookManagementSystem.Server.BorrowServer;
import com.bookManagementSystem.Server.StudentServer;
import com.bookManagementSystem.Server.impl.BookServerImpl;
import com.bookManagementSystem.Server.impl.BorrowServerImpl;
import com.bookManagementSystem.Server.impl.StudentServerImpl;
import com.bookManagementSystem.utils.ThymeleafUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.thymeleaf.context.Context;

import java.io.IOException;
@WebServlet("/index")
public class IndexServlet extends HttpServlet {
    BorrowServer server;
    BookServer server2;
    StudentServer server3;
    @Override
    public void init() throws ServletException {
        server = new BorrowServerImpl();
        server2 = new BookServerImpl();
        server3 = new StudentServerImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Context context = new Context();
        User user =(User) req.getSession().getAttribute("user");
        context.setVariable("nickname",user.getNickname());
        context.setVariable("borrow_list",server.getBorrowList());
        context.setVariable("student_count",server3.getStudentList().size());
        context.setVariable("book_count",server2.getBookList().size());
        context.setVariable("borrow_list.size()",server.getActiveBookList().size());
        ThymeleafUtil.process("index.html",context,resp.getWriter());
    }
}
