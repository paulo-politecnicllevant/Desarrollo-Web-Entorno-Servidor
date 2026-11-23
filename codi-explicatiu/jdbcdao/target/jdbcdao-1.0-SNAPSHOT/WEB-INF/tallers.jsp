<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tallers</title>
</head>
<body>

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

<h2>Nou taller</h2>

<c:if test="${not empty errors}">
    <ul>
        <c:forEach items="${errors}" var="error">
            <li><c:out value="${error}"/></li>
        </c:forEach>
    </ul>
</c:if>

<form action="${pageContext.request.contextPath}/tallers" method="post">
    <p>
        <label>Codi: <input type="text" name="id" value="<c:out value='${nou.id}'/>"></label>
    </p>
    <p>
        <label>Nom: <input type="text" name="nom" value="<c:out value='${nou.nom}'/>"></label>
    </p>
    <p>
        <label>Ponent: <input type="text" name="ponent" value="<c:out value='${nou.ponent}'/>"></label>
    </p>
    <p>
        <label>Dia: <input type="date" name="dia" value="${nou.dia}"></label>
    </p>
    <p>
        <label>Places: <input type="text" name="places" value="${nou.places}"></label>
    </p>
    <p>
        <label>Preu: <input type="text" name="preu" value="${nou.preu}"></label>
    </p>
    <button type="submit">Crear taller</button>
</form>

</body>
</html>