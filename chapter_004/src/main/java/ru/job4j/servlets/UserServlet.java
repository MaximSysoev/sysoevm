package ru.job4j.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class UserServlet extends HttpServlet {

    private final ValidateService logic = ValidateService.getInstance();
    private int id = 0;

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {

        StringBuilder sb = new StringBuilder("<table>");
        for (User user : logic.findAll()) {
            if (user.getName() != null || user.getLogin() != null || user.getEmail() != null) {
                sb.append("<form action='/list?id="+user.getId()+"' method='post'>" +
                        "<tr><td>" + user.getName() + " | </td>" +
                        "<td>" + user.getLogin() + " | </td>" +
                        "<td>" + user.getEmail() + " | </td>" +
                        "<td>" + user.getCreateDate() + " | </td>" +
                        "<td><a href='edit?id="+user.getId()+"'>Редактировать</a></td>" +
                        "<td><input type='submit' value='Удалить'/></td>" +
                        "</tr>" +
                        "</form>");
            }
        }
        sb.append("</table>");

        res.setContentType("text/html");
        PrintWriter writer = new PrintWriter(res.getOutputStream());
        List<User> lst = logic.findAll();
        writer.append("<!DOCTYPE HTML>" +
                "<html>" +
                "<head>" +
                "<title>#2513</title>" +
                "</head>" +
                "<body>" +
                "</br>" +
                 sb.toString() +
                "</body>" +
                "</html>");
        writer.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        int id = Integer.parseInt(req.getParameter("id"));
        logic.delete(id);

        /*String action = req.getParameter("action");
        if (action.equals("add")) {
            String name = req.getParameter("name");
            logic.add(new User(id++, name, name, name + "@email", new Date()));
        } else if (action.equals("update")) {
            String name = req.getParameter("name");
            int key = Integer.parseInt(req.getParameter("id"));
            logic.update(key, new User(key, name,  name,name + "@email", new Date()));
        } else if (action.equals("delete")) {
            int key = Integer.parseInt(req.getParameter("id"));
            logic.delete(key);
        }*/

        doGet(req, resp);

    }
}
