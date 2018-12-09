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
        int index = 0;
        res.setContentType("text/html");
        PrintWriter writer = new PrintWriter(res.getOutputStream());
        List<User> lst = logic.findAll();
        for (User user : lst) {
            writer.append("   " + lst.get(index).id + ") " + lst.get(index).name + "  /  ");
            index++;
        }
        writer.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String action = req.getParameter("action");

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
        }

        doGet(req, resp);

    }
}
