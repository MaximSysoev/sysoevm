package ru.job4j.servlets.userstore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

public class UserCreateServlet extends HttpServlet {

    private final ValidateService logic = ValidateService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        HttpSession session = req.getSession();
        String login = session.getAttribute("login").toString();
        req.setAttribute("login", login);
        req.setAttribute("roles", logic.findAllRoles());
        req.getRequestDispatcher("/WEB-INF/jsp/create.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        User user = new User(0, req.getParameter("name"), req.getParameter("login"), req.getParameter("email"), new Date(), req.getParameter("password"), Integer.parseInt(req.getParameter("roles")));
        if (!logic.contain(user)) {
            logic.add(user);
            resp.sendRedirect(String.format("%s/list", req.getContextPath()));
        } else {
            req.setAttribute("error", "Заполните заново поля");
            //resp.sendRedirect(String.format("%s/", req.getContextPath()));
            req.getRequestDispatcher("/WEB-INF/jsp/create.jsp").forward(req, resp);
        }
    }
}