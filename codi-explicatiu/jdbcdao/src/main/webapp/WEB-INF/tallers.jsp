<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tallers</title>
</head>
<body>

<c:choose>
    <c:when test="${empty usuari}">
        <p><a href="${pageContext.request.contextPath}/login">Entrar</a></p>
    </c:when>
    <c:otherwise>
        <form action="${pageContext.request.contextPath}/logout" method="post">
            Hola <c:out value="${usuari}"/>
            | <a href="${pageContext.request.contextPath}/gestio/nou-taller">Nou taller</a>
            <button type="submit">Sortir</button>
        </form>
    </c:otherwise>
</c:choose>

<h1>Llista tallers</h1>

<table border="1">
    <tr>
        <th>Id</th>
        <th>Nom</th>
        <th>Ponent</th>
        <th>Dia</th>
        <th>Places</th>
        <th>Preu</th>
    </tr>
    <c:forEach items="${tallers}" var="taller">
        <tr>
            <td><c:out value="${taller.id}"/></td>
            <td><c:out value="${taller.nom}"/></td>
            <td><c:out value="${taller.ponent}"/></td>
            <td>${taller.diaText}</td>
            <td>${taller.places}</td>
            <td>${taller.preu}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>