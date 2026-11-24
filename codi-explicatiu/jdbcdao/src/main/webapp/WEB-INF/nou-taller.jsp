<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<html>
<head>
    <title>Nou taller</title>
</head>
<body>

<h1>Nou taller</h1>

<c:if test="${not empty errors}">
    <ul>
        <c:forEach items="${errors}" var="error">
            <li><c:out value="${error}"/></li>
        </c:forEach>
    </ul>
</c:if>

<form action="${pageContext.request.contextPath}/gestio/nou-taller" method="post">
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

<p><a href="${pageContext.request.contextPath}/tallers">Tornar a la llista de tallers</a></p>

</body>
</html>