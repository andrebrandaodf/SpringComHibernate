<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de Cliente</title>
</head>
<body>
	<table>
		<tr>
			<th>Nome</th>
			<th>E-mail</th>
			<th>Gerenciar</th>
		</tr>
		<c:forEach items="${listaCliente}" var="cliente">
			<tr>
				<td>${cliente.nome}</td>
				<td>${cliente.email}</td>
				<td>
					<a href="excluirCliente?id=${cliente.id}">X</a>
					<a href="buscarAlterarCliente?id=${cliente.id}">A</a>
				</td>	
			</tr>
		</c:forEach>
	</table>
</body>
	<!-- LOGO ABAIXO DO BODY -->
	<form action="listarCliente.jsp">
		<label>Nome</label>
		<input type="text" name="nome" />
		<input type="submit" value="Procurar" />
	</form>
</html>