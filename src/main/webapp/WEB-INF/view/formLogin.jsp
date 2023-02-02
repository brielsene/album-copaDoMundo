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

Login: <input type="text" name="login"/>
Senha: <input type="text" name="senha"/>

<input type="hidden" name="acao" value="Login">
<input type="submit" value="Login "/>

</form>


</body>
</html>