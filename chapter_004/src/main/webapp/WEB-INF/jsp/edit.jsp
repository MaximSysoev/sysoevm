<%@ page import="ru.job4j.servlets.User" %>
<%@ page import="ru.job4j.servlets.ValidateService" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    ValidateService logic = ValidateService.getInstance();
    int id = Integer.parseInt(request.getParameter("id"));
    User user = logic.findById(id);
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit</title>
</head>
<body>
<form action = "" method="post">
    <table>
         <tr>
            <td><input type = "text" name="name" value = <%=user.getName()%>></td>
            <td><input type = "text" name = "login" value = <%=user.getLogin()%>></td>
            <td><input type = "text" name = "email" value = <%=user.getEmail()%>></td>
            <td><input type = "submit" value = "Сохранить"/></td>
         </tr>
    </table>
</form>
<p><a href="/list">Список всех пользователей</a></p>
</body>
</html>
