<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de Produtos</title>
</head>
<body>
	
	<form action="pesquisarProduto">
		<label>Nome</label>
		<input type="text" name="nome"/>
		<input type="submit" value="Procurar"/>
	</form>
	
	<table>
		<tr>	
			<th>Nome</th>
			<th>Valor</th>
			<th>Descricao</th>
			<th>Gerenciar</th>
		</tr>
		<c:forEach items="${listaProduto}" var="produto">
			<tr>
			<td>${produto.nome}</td>
			<td>
				<fmt:formatNumber value="${produto.valor}" type="currency"/>
			</td>
			<td>${produto.descricao}</td>
			<td>
			<a href="excluirProduto?id=${produto.id}">X</a>
			<a href="buscarAlterarProduto?id=${produto.id}">A</a> 	
		</c:forEach>	
	</table>
</body>
</html>