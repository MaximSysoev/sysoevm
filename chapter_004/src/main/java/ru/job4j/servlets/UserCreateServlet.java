package ru.job4j.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class UserCreateServlet extends HttpServlet {

    private final ValidateService logic = ValidateService.getInstance();
    private int id = 0;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.getRequestDispatcher("/WEB-INF/jsp/create.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        logic.add(new User(id++, req.getParameter("name"), req.getParameter("login"), req.getParameter("email"), new Date()));
        req.getRequestDispatcher("/WEB-INF/jsp/create.jsp").forward(req, resp);
    }
}
