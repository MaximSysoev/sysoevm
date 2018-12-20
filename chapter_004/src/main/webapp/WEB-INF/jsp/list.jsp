<%@ page import="ru.job4j.servlets.userstore.User" %>
<%@ page import="ru.job4j.servlets.userstore.ValidateService" %>
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
<% List<User> users = (List<User>) request.getAttribute("users"); %>
<table>
    <tr><td><a href="<%=request.getContextPath()%>/">Добавить пользователя</a></td></tr>
<%
    for (User user : users) {
%>

<form action = "<%=request.getContextPath()%>/list?id=<%=user.getId()%>"  method = "post">
    <tr>
        <td><%=user.getName()%></td>
        <td><%=user.getLogin()%></td>
        <td><%=user.getEmail()%></td>
        <td><a href="<%=request.getContextPath()%>/edit?id=<%=user.getId()%>" >Редактировать</a></td>
        <td><input type = "submit" value="Удалить"/></td>
    </tr>
</form>
<%
    }
%>
</table>
</body>
</html>
