<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro de Produtos</title>
</head>
<body>
	<form action="cadastroProduto">
		<label>Nome:</label>
		<input type="hidden" name="id" value="${produto.id}" />
		<input type="text" name="nome" value="${produto.nome}" />
		<label>Valor:</label>
		<input type="text" name="valor" value="${produto.valor}" />
		<label>Descricao:</label>
		<input type="text" name="descricao" value="${produto.descicao}" />
		<input type="submit" value="Enviar" />
	</form>
</body>
</html>ml>