<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Edit page</title>
</head>
<body>
<c:set var = "u" value = "${user}"></c:set>
<form action = "${pageContext.servletContext.contextPath}/edit?id=<c:out value="${u.id}"></c:out>" method="post">
    <table>
         <tr>
            <td><input type = "text" name="name" value = "<c:out value="${u.name}"/>"></td>
            <td><input type = "text" name = "login" value =  "<c:out value="${u.login}"/>"></td>
            <td><input type = "text" name = "email" value =  "<c:out value="${u.email}"/>"></td>
            <td><input type = "submit" value = "Сохранить"/></td>
         </tr>
    </table>
</form>
<p><a href="${pageContext.servletContext.contextPath}/list">Список всех пользователей</a></p>
</body>
</html>
