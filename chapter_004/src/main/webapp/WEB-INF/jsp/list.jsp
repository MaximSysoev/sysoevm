<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>List page</title>
</head>
<body>

<table>
<tr><td><a href="${pageContext.servletContext.contextPath}/">Добавить пользователя</a></td></tr>
<c:forEach items="${users}" var="user">
    <form action = "${pageContext.servletContext.contextPath}/list?id=<c:out value="${user.id}"/>" method = "post">
    <tr>
        <td><c:out value="${user.name}"></c:out></td>
        <td><c:out value="${user.login}"></c:out></td>
        <td><c:out value="${user.email}"></c:out></td>
        <td><a href="${pageContext.servletContext.contextPath}/edit?id=${user.id}">Редактировать</a></td>
        <td><input type = "submit" value="Удалить"/></td>
    </tr>
</form>
</c:forEach>
</table>
</body>
</html>
