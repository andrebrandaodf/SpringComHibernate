<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro de Cliente</title>
</head>
<body>
	<h1>Cadastro de Clientes</h1>
	
	<form action="cadastroCliente">
		<label>Nome:</label>
		<!-- <input type="hidden" name="id" value="${cliente.id}" />  -->
		<input type="text" name="nome" value="${cliente.nome}" />
		
		<label>E-mail:</label>
		<input type="text" name="email" value="${cliente.email}" />
		<input type="submit" value="Enviar" />
	</form>
</body>
</html>