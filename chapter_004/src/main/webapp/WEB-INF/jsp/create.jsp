<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Create page</title>
</head>
<body>

<c:if test="${error==null}">
    ${error=""}
</c:if>

<h1 align="center"><c:out value="${error}"></c:out></h1>
<form action = "${pageContext.servletContext.contextPath}/" method = "post">
    <table>
    <tr>
        <td>Имя</td><td><input type = "text" name="name"></td>
     </tr>
    <tr>
        <td>Логин</td><td><input type = "text" name="login"></td>
        </tr>
    <tr>
        <td>E-mail</td><td><input type = "text" name="email"></td>
        </tr>
    <tr>
        <td><input type="submit" value = "Создать"/></td>
     </tr>
    </table>
    <p><a href="${pageContext.servletContext.contextPath}/list">Список всех пользователей</a></p>
</form>
</body>
</html>
