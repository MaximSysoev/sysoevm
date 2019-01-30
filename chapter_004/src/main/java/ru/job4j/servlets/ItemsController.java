package ru.job4j.servlets;

import ru.job4j.servlets.userstore.User;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.*;
import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ItemsController extends HttpServlet {

    private final static String baseFile = "user.json";
    ConcurrentHashMap<String, User> map = new ConcurrentHashMap<>();

    public static void toJSON(User user) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File(baseFile), user);
        System.out.println("json created!");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        req.getRequestDispatcher("/WEB-INF/jsp/Items.html").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        User user = new User(0, "name", "login", req.getParameter("email"), new Date(), req.getParameter("pwd"), 1);
        toJSON(user);
        map.put(req.getParameter("pwd"), mapper.readValue(new File(baseFile), User.class));


    }
}
