<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edição do Produto</title>
</head>
<body>
	<form action="altera">
		<fieldset>
			<legend>Edição do Produto</legend>
			
			<input type="hidden" name="produto.id" value="${produto.id}"></input>
			
			<label for="nome">Nome</label><br/>
			<input type="text" name="produto.nome" value="${produto.nome}"></input><br/>
			
			<label for="nome">Preço</label><br/>
			<input type="text" name="produto.preco" value="${produto.preco}"></input><br/>
			
			<input type="submit" value="Atualizar"></input>			
		</fieldset>
	</form>
</body>
</html>