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
Senha: <input type="password" name="senha"/>
Senha: <input type="password" name="senha2"/>
<br><br><br>
${msgErro }

<input type="hidden" name="acao" value="CadastroUsuario">
<input type="submit" value="Cadastrar "/>

<br><br>


</form>


</body>
</html>