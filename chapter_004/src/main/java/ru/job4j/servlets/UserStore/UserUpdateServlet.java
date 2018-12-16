package ru.job4j.servlets.UserStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

public class UserUpdateServlet extends HttpServlet {

    private final ValidateService logic = ValidateService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/edit.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String login = req.getParameter("login");
        String email = req.getParameter("email");
        User user = new User(id, name, login, email, new Date());
        logic.update(id, user);
        req.getRequestDispatcher("/WEB-INF/jsp/edit.jsp").forward(req, resp);
    }
}
