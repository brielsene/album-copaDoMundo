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
<p>Nome do Jogador: <input type="text" name="jogador"/>
N�mero: <input type="text" name="numero"/>
Sele��o: <input type="text" name="selecao"/>
</p>
<input type="hidden" name="acao" value="CadastraJogador">
<input type="submit" value="Cadastrar Jogador"/>

</form>


</body>
</html>