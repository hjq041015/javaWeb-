package com.bookManagementSystem.Control.manage;

import com.bookManagementSystem.Server.BorrowServer;
import com.bookManagementSystem.Server.impl.BorrowServerImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet("/return-book")
public class BookReturnServlet extends HttpServlet {
    BorrowServer server;
    @Override
    public void init() throws ServletException {
        server = new BorrowServerImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        server.deleteBorrow(id);
        resp.sendRedirect("/index");
    }
}
