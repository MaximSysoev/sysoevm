package ru.job4j.servlets.userstore;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;


public class UserUpdateServlet extends HttpServlet {

    private final ValidateService logic = ValidateService.getInstance();

    @Override
    public void destroy() {
        super.destroy();
        logic.close();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> users = logic.findAll();
        resp.setContentType("text/json");
        PrintWriter writer = new PrintWriter(resp.getOutputStream());
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(writer, users.toArray());
        writer.flush();
        req.getRequestDispatcher("update.html").forward(req, resp);


      /*  HttpSession session = req.getSession();
        int role_id = logic.findByLogin(session.getAttribute("login").toString());
        req.setAttribute("login", session.getAttribute("login").toString());
        req.setAttribute("role", role_id);
        req.setAttribute("roles", logic.findAllRoles());
        req.setAttribute("user", logic.findById(Integer.parseInt(req.getParameter("id"))));
        req.getRequestDispatcher("/WEB-INF/jsp/edit.jsp").forward(req, resp);*/

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String login = req.getParameter("login");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        int role = Integer.parseInt(req.getParameter("roles"));
        User user = new User(id, name, login, email, new Date(), password, "", "", role);
        logic.update(id, user);
        resp.sendRedirect(String.format("%s/edit?id=%s", req.getContextPath(), req.getParameter("id")));
    }
}
