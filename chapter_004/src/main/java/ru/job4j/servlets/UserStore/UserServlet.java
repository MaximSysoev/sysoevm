package ru.job4j.servlets.userstore;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


public class UserServlet extends HttpServlet {
    private final ValidateService logic = ValidateService.getInstance();

    @Override
    public void destroy() {
        super.destroy();
        logic.close();
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
       // HttpSession session = req.getSession();
       // int role_id = logic.findByLogin(session.getAttribute("login").toString());
       // req.setAttribute("login", session.getAttribute("login").toString());
       // req.setAttribute("role", role_id);
      //  req.setAttribute("users", logic.findAll());
      //  req.getRequestDispatcher("/WEB-INF/jsp/list.jsp").forward(req, res);
        List<User> users = logic.findAll();
        resp.setContentType("text/json");
        PrintWriter writer = new PrintWriter(resp.getOutputStream());
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(writer, users.toArray());
        writer.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        int id = Integer.parseInt(req.getParameter("id"));
        logic.delete(id);
        resp.sendRedirect(String.format("%s/list", req.getContextPath()));
    }
}
