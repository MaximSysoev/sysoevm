<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Edit page</title>
</head>
<body>
<form action = "" method="post">
    <table>
         <tr>
            <td><input type = "text" name="name" value = "<c:out value="${user.name}"/>"></td>
            <td><input type = "text" name = "login" value =  "<c:out value="${user.login}"/>"></td>
            <td><input type = "text" name = "email" value =  "<c:out value="${user.email}"/>"></td>
            <td><input type = "submit" value = "Сохранить"/></td>
         </tr>
    </table>
</form>
<p><a href="${pageContext.servletContext.contextPath}/list">Список всех пользователей</a></p>
</body>
</html>
