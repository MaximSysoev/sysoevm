package ru.job4j.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class UserUpdateServlet extends HttpServlet {

    private final ValidateService logic = ValidateService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = new PrintWriter(resp.getOutputStream());
        int id = Integer.parseInt(req.getParameter("id"));
        User user = logic.findById(id);

            StringBuilder sb = new StringBuilder("<form action = '' method='post'><table>");
            sb.append("<tr>" +
                    "<td><input type = 'text' name='name' value = '" + user.getName() + "'/></td>" +
                    "<td><input type = 'text' name = 'login' value = '" + user.getLogin() + "'></td>" +
                    "<td><input type = 'text' name = 'email' value = '" + user.getEmail() + "'></td>" +
                    "<td><input type = 'submit' value = 'Save'/></td>" +
                    "</tr>"
            );
            sb.append("</table></form>");

        writer.append("<!DOCTYPE HTML>" +
                "<html>" +
                "<head>" +
                "<title>#2513</title>" +
                "</head>" +
                "<body>" +
                "</br>" +
                sb.toString() +
                "<p><a href='" + req.getContextPath() + "/list'>Список всех пользователей</a></p>" +
                "</body>" +
                "</html>");

        writer.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String login = req.getParameter("login");
        String email = req.getParameter("email");
        User user = new User(id, name, login, email, new Date());
        logic.update(id, user);
        doGet(req, resp);
    }
}
