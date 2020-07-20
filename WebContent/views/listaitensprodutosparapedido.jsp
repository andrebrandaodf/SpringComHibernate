<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de Produtos</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script type="text/javascript">
		function adicionar(id, valor){
			/*produto.id é o produto e valor é do itens */
			$.get("adicionarItem?produto.id=" + id + "&valor="+valor);
		}
	</script>
</head>
<body>

	<form action="fecharPedido">
		<label>Nome do cliente</label>
		
		<select name="id">
			<c:forEach items="${listaCliente}" var="cliente">
				<option value="${cliente.id}">${cliente.nome}</option>
			</c:forEach>
		</select>
		
		<table>
			<tr>
				<th>Nome</th>
				<th>Descricao</th>
				<th>Valor</th>
				<th>Gerenciar</th>
			</tr>	
			<c:forEach items="${listaProdutos}" var="produto">
				<tr>	
					<td>${produto.id}</td>
					<td>${produto.nome}</td>
					<td>${produto.descricao}</td>
					<td>${produto.valor}</td>
					<td>
						<a href="#" onclick="adicionar(${produto.id}, ${produto.valor})">Adicionar ao Pedido</a>
						<a href="removerDaLista?id=${produto.id}">A</a>
					</td>	
			</c:forEach>
		</table>
		<input type="submit" value="Fechar Pedido" />
	</form>
</body>
</html>