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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("<form action='' method = 'post'>" +
                "<table>" +
                "<tr>" +
                "<td>Имя</td><td><input type = 'text' name='name'/></td>" +
                "</tr>" +
                "<tr>" +
                "<td>Логин</td><td><input type = 'text' name='login'/></td>" +
                "</tr>" +
                "<tr>" +
                "<td>E-mail</td><td><input type = 'text' name='email'/></td>" +
                "</tr>" +
                "<tr>" +
                "<td><input type='submit' value = 'Создать'/></td>" +
                "</tr>" +
                "</table>"+
                "</form>");

        resp.setContentType("text/html");
        PrintWriter writer = new PrintWriter(resp.getOutputStream());
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
        logic.add(new User(id, req.getParameter("name"), req.getParameter("login"), req.getParameter("email"), new Date()));
        doGet(req, resp);
    }
}
