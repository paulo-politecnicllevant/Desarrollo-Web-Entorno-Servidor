<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Información del taller</title>
</head>
<body>
    <h1>Información del taller</h1>
    <table border="1">
        <tr>
            <th>ID</th>
            <td><c:out value="${taller.id}"/></td>
        </tr>
        <tr>
            <th>Nombre</th>
            <td><c:out value="${taller.nom}"/></td>
        </tr>
        <tr>
            <th>Ponente</th>
            <td><c:out value="${taller.ponent}"/></td>
        </tr>
        <tr>
            <th>Día</th>
            <td>${taller.diaText}</td>
        </tr>
        <tr>
            <th>Plazas</th>
            <td>${taller.places}</td>
        </tr>
        <tr>
            <th>Precio</th>
            <td>${taller.preu} €</td>
        </tr>
    </table>
    <br>
    <a href="${pageContext.request.contextPath}/tallers">
        Volver a la lista de talleres
    </a>

</body>
</html>