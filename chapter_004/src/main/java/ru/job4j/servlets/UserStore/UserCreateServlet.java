package ru.job4j.servlets.userstore;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;


public class UserCreateServlet extends HttpServlet {

    private final ValidateService logic = ValidateService.getInstance();

    @Override
    public void destroy() {
        super.destroy();
        logic.close();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
     //   HttpSession session = req.getSession();
     //   String login = session.getAttribute("login").toString();
     //   req.setAttribute("login", login);
     //   req.setAttribute("roles", logic.findAllRoles());
        //req.getRequestDispatcher("/WEB-INF/jsp/create.jsp").forward(req, resp);
        req.getRequestDispatcher("adduser.html").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String name = req.getParameter("name");
        String login = req.getParameter("login");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String country = req.getParameter("country");
        String city = req.getParameter("city");

        switch (country) {
            case "rus":
                country = "Россия";
                switch (city) {
                    case "0": city="Москва";
                        break;
                    case "1": city="Санкт-Петербург";
                        break;
                }
                break;
            case "ger":
                country = "Германия";
                switch (city) {
                    case "0": city="Берлин";
                        break;
                    case "1": city="Гамбург";
                        break;
                }
                break;
            case "chili":
                country = "Чили";
                switch (city) {
                    case "0": city="Сантьяго";
                        break;
                    case "1": city="Вальпараисо";
                        break;
                }
                break;
        }

        User user = new User(0, name, login, email, new Date(), password, country, city,1);
        logic.add(user);
        resp.sendRedirect(String.format("%s/adduser", req.getContextPath()));


       /* if (!logic.contain(user)) {
            logic.add(user);
            resp.sendRedirect(String.format("%s/list", req.getContextPath()));
        } else {
            req.setAttribute("error", "Заполните заново поля");
            //resp.sendRedirect(String.format("%s/", req.getContextPath()));
            req.getRequestDispatcher("/WEB-INF/jsp/create.jsp").forward(req, resp);
        }*/
    }
}