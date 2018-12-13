
<%@ page import="ru.job4j.servlets.User" %>
<%@ page import="ru.job4j.servlets.ValidateService" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    ValidateService logic = ValidateService.getInstance();
%>
<html>
<head>
    <title>List</title>
</head>
<body>
<table>
    <tr><td><a href="/">Добавить пользователя</a></td></tr>
<%
    for (User user : logic.findAll()) {
%>
<form action = "<%request.getContextPath();%>?id=<%=user.getId()%>"  method = "post">
    <tr>
        <td><%=user.getName()%></td>
        <td><%=user.getLogin()%></td>
        <td><%=user.getEmail()%></td>
        <td><%=user.getCreateDate()%></td>
        <td><a href="<%request.getContextPath();%>edit.jsp?id=<%=user.getId() %>" >Редактировать</a></td>
        <td><input type = "submit" value="Удалить"/></td>
    </tr>
</form>
<%
    }
%>
</table>
</body>
</html>
