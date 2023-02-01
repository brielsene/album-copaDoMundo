<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<style>
body{
background-image: url("word-cup.png");
box-sizing: content-box;
background-size: 100%;
}
</style>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro Jogador</title>
</head>

<body>




<form action="/album-worldcup/controller" method="post">
<p>Nome do Jogador: <input type="text" name="jogador" value="${jogador }"/>
Número: <input type="text" name="numero" value="${numero }"/>
Seleção: <input type="text" name="selecao" value="${selecao }"/>

</p>
<input type="hidden" name="id" value="${id }"/> 
<input type="hidden" name="acao" value="EditaFigurinha">
<input type="submit" value="Alterar Jogador"/>

</form>


</body>
</html>