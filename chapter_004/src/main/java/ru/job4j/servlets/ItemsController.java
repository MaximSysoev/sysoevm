package ru.job4j.servlets;

import ru.job4j.servlets.userstore.User;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.*;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ItemsController extends HttpServlet {

    private final static String baseFile = "user.json";
    ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //map.put("1", new User(0, "Andrei", "login", "email@email", new Date(), "password", 2));
        //map.put("2", new User(0, "Maxim", "login2", "email2@email2", new Date(), "password2", 2));
        resp.setContentType("text/json");
        PrintWriter writer = new PrintWriter(resp.getOutputStream());
        int count = 0;
        ObjectMapper mapper = new ObjectMapper();
        StringBuilder builder = new StringBuilder();
            for (Map.Entry<String,  String> entry : map.entrySet()) {
                if (count!=map.size()-1) {
                   builder.append("{password:"  + entry.getKey()  + "," + "email:"  + entry.getValue() + "}," );
                } else {
                    builder.append("{\'password\':" + '\'' + entry.getKey() + '\'' + "," + "\'email\':" + '\'' + entry.getValue() + '\'' + "}" );
                }
                count++;
        }
        mapper.writeValue(writer, map.values().toArray());
        //String json = mapper.writeValueAsString(builder);
      //  writer.append("[{\"password\":\"password\", \"login\":\"login\"}, {\"password\":\"password\", \"login\":\"login\"}]");
        writer.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        BufferedReader reader = req.getReader();
        final User user = mapper.convertValue(reader, User.class);
        String email = req.getParameter("email");
        String pwd = req.getParameter("pwd");
        map.put(email, pwd);
    }
}
