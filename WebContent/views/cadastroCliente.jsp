<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>OLA</h1>
	<h2>${cliente.nome}</h2>
	 <p>Parametro nome = "<%= request.getAttribute("nome") %>"</p>
     <p>Pagina chamada a partir do mapping em ParamController</p>
</body>
</html>