<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
</head>
<body>

<%String nom = "pere"; %>
<%for (int i = 0; i < 4; i++){ %>
  <h1><%= nom %></h1>
<% } %>
<br/>
<a href="parametres">Servlet de parámetros</a>
</body>
</html>