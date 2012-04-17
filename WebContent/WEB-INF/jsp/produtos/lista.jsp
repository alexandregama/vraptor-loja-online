<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>Produtos:</h3>
	
	<table id="produtos">
		<thead>
			<tr>
				<th>Cod</th>
				<th>Nome</th>
				<th>Preço</th>
			</tr>
		</thead>
		<c:forEach items="${produtoList}" var="produto">
			<tr>
				<td>${produto.id}</td>
				<td>${produto.nome}</td>
				<td>${produto.preco}</td>
			</tr>			
		</c:forEach>
	</table>
	
	<a href="<c:url value="/produtos/lista"/>">Lista Produtos</a>
</body>
</html>