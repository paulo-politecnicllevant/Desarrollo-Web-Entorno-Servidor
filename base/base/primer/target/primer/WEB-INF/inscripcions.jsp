<%@ page import="org.example.primer.Inscripcio" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>Som de <%= request.getAttribute("ciutat") %></h1>

<h2>Llista d'inscripcions</h2>

<%List<Inscripcio> inscripcions = (List<Inscripcio>)request.getAttribute("inscripcions");%>

<table border="1px solid black">
    <tr>
        <th>Nom</th>
        <th>Edat</th>
        <th>Estudis</th>
    </tr>
<% for(Inscripcio inscripcio : inscripcions){%>
    <tr>
        <td> <%= inscripcio.getNom() %></td>
        <td> <%= inscripcio.getEdat() %></td>
        <td> <%= inscripcio.getEstudis() %></td>
    </tr>
<%}%>
</table>
<br>
<a href="formulari.html">Nova inscripcio</a>
</body>
</html>
