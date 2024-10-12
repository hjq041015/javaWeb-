package com.bookManagementSystem.Control.manage;

import com.bookManagementSystem.Server.BorrowServer;
import com.bookManagementSystem.Server.StudentServer;
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
@WebServlet("/add-borrow")
public class AddBorrowServlet extends HttpServlet {
    BorrowServer server;
    StudentServer server2;
    @Override
    public void init() throws ServletException {
        server = new BorrowServerImpl();
        server2 = new StudentServerImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Context context = new Context();
        context.setVariable("book_list",server.getActiveBookList());
        context.setVariable("student_list",server2.getStudentList());
        ThymeleafUtil.process("add-borrow.html",context,resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int book = Integer.parseInt(req.getParameter("book"));
        int student = Integer.parseInt(req.getParameter("student"));

        server.addBorrow(student,book);
        resp.sendRedirect("/index");
    }
}
