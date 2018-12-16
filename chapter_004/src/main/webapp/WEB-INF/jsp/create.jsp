<%@ page import="ru.job4j.servlets.ValidateService" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    ValidateService logic = ValidateService.getInstance();
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create</title>
</head>
<body>
<% String errorl = (String) request.getAttribute("error"); %>

<%
    if (errorl == null) {
        errorl = "";
    }
%>
<h1 align="center"><%=errorl%></h1>
<form action = "<%=request.getContextPath()%>/" method = "post">
    <table>
    <tr>
        <td>Имя</td><td><input type = "text" name="name"/></td>
     </tr>
    <tr>
        <td>Логин</td><td><input type = "text" name="login"/></td>
        </tr>
    <tr>
        <td>E-mail</td><td><input type = "text" name="email"/></td>
        </tr>
    <tr>
        <td><input type="submit" value = "Создать"/></td>
     </tr>
    </table>
    <p><a href="<%=request.getContextPath()%>/list">Список всех пользователей</a></p>
</form>
</body>
</html>
