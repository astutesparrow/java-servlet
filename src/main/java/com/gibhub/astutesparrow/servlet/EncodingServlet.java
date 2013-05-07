package com.gibhub.astutesparrow.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * User: 智深
 * Date: 13-5-7
 */
public class EncodingServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String queryString = req.getQueryString();
        String encoding = req.getCharacterEncoding();
        // req.setCharacterEncoding("utf-8");
        String ch = req.getParameter("ch");
        String en = req.getParameter("en");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
