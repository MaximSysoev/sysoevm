
<%@ page import="ru.job4j.servlets.UserStore.User" %>
<%@ page import="ru.job4j.servlets.UserStore.ValidateService" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    ValidateService logic = ValidateService.getInstance();
%>
<html>
<head>
    <title>List page</title>
</head>
<body>
<% //List<User> users = (List<User>) request.getAttribute("users"); %>
<table>
    <tr><td><a href="/">Добавить пользователя</a></td></tr>

<%
 //   for (User user : users) {
%>
<form action = "/list?id="  method = "post">
    <tr>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td><a href="/edit?id=" >Редактировать</a></td>
        <td><input type = "submit" value="Удалить"/></td>
    </tr>
</form>
<%
 //   }
%>
</table>
</body>
</html>
