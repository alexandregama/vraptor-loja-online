<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Formulário de Cadastro</title>
</head>
<body>
	<h3>Cadastro de Produtos</h3>
	
	<form action="adiciona">
		<fieldset>
			<legend>Adicionar Produto</legend>
			
			<label for="nome">Nome</label><br/>
			<input type="text" id="nome" name="produto.nome"></input><br/>
			
			<label for="nome">Preço</label><br/>
			<input type="text" id="preco" name="produto.preco"></input><br/>
			
			<input type="submit" value="Enviar"></input>
		</fieldset>
	</form>
</body>
</html>