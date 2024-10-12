package com.bookManagementSystem.Control.manage;

import com.bookManagementSystem.Server.BookServer;
import com.bookManagementSystem.Server.impl.BookServerImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/delete-book")
public class DeleteBookServlet extends HttpServlet {
    BookServer server;

    @Override
    public void init() throws ServletException {
        server =  new BookServerImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       int bid = Integer.parseInt(req.getParameter("bid"));
       server.deleteBook(bid);
       resp.sendRedirect("/books");
    }
}
