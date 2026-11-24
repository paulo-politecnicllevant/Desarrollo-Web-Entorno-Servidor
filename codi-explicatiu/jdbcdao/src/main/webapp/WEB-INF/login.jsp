<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Entrar</title>
</head>
<body>

<h1>Entrar</h1>

<c:if test="${not empty error}">
    <p><c:out value="${error}"/></p>
</c:if>

<form action="${pageContext.request.contextPath}/login" method="post">
    <p>
        <label>Usuari: <input type="text" name="nom" value="<c:out value='${nom}'/>"></label>
    </p>
    <p>
        <label>Contrasenya: <input type="password" name="contrasenya"></label>
    </p>
    <button type="submit">Entrar</button>
</form>

</body>
</html>
