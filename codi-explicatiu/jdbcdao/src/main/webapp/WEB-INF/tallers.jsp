<%@ page import="org.example.jdbcdao.model.Taller" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>Llista tallers</h1>

<%List<Taller> tallers = (List<Taller>)request.getAttribute("tallers");%>

<table border="1px solid black">
    <tr>
        <th>Id</th>
        <th>Nom</th>
        <th>Ponent</th>
        <th>Dia</th>
        <th>Places</th>
        <th>Preu</th>
    </tr>
    <% for(Taller taller : tallers){ %>
    <tr>
        <td> <%= taller.getId() %></td>
        <td> <%= taller.getNom() %></td>
        <td> <%= taller.getPonent() %></td>
        <td> <%= taller.getDia() %></td>
        <td> <%= taller.getPlaces() %></td>
        <td> <%= taller.getPreu() %></td>
    </tr>
    <%}%>
</table>
</body>
</html>
