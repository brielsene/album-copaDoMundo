<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista De Figurinhas</title>
</head>
<body>
Lista de figurinhas: 
<br><br><br>

<c:forEach items="${lista }" var="lista">
<ul>
Jogador: ${lista.jogador }
Número: ${lista.numero }
Selecao: ${lista.selecao }
<a href="controller?acao=MostraFigurinha&id=${lista.id }">Editar</a>
<a href="controller?acao=RemoveFigurinha&id=${lista.id }">Deletar</a>
</ul>
</c:forEach>

</body>
</html>