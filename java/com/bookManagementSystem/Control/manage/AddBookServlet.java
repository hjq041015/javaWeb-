package com.bookManagementSystem.Control.manage;

import com.bookManagementSystem.Server.BookServer;
import com.bookManagementSystem.Server.impl.BookServerImpl;
import com.bookManagementSystem.utils.ThymeleafUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.thymeleaf.context.Context;

import java.io.IOException;
@WebServlet("/add-book")
public class AddBookServlet extends HttpServlet {
    BookServer server;

    @Override
    public void init() throws ServletException {
        server =  new BookServerImpl();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ThymeleafUtil.process("add-book.html",new Context(),resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        String desc = req.getParameter("desc");
        Double price = Double.parseDouble(req.getParameter("price"));
        server.addBook(title,desc,price);
        resp.sendRedirect("/books");
    }
}

