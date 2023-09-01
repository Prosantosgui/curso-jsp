<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tela de erro</title>
</head>
<body>
	<h1>Entre em contato com a equipe de suporte do sistema!</h1>
	<h3>${msg}</h3>
	<textarea rows="20" cols="50">${msg}</textarea>
	
	<%
		out.print(request.getAttribute("msg"));
	%>
</body>
</html>