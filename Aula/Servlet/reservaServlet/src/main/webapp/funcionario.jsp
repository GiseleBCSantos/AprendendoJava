<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="entities.Funcionario" %>
<%@ page import="java.util.ArrayList" %>
<%
	ArrayList<Funcionario> lista = (ArrayList<Funcionario>) request.getAttribute("funcionarios"); 
%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<title>Agenda</title>
<link rel="stylesheet" href="styles.css">
</head>
<body>
<div class="center-center-container pagina-listagem">
	<h1>Lista de Funcionarios</h1>
	<a href="index.html" class="botao-voltar"> <-- Voltar</a>
	<a href="criarFuncionario.html">Novo funcionario</a>
	
	<table class="tabela">
		<thead>
			<tr>
				<th>Id</th>
				<th>Nome</th>
				<th>Email</th>
			</tr>
		</thead>
		<tbody>
			<% for (int i = 0; i < lista.size(); i++) {%>
				<tr>
					<td><%= lista.get(i).getId() %></td>
					<td><%= lista.get(i).getNome() %></td>
					<td><%= lista.get(i).getEmail() %></td>
					
				</tr>
			<%} %>
		</tbody>
	<tr>
	</tr>
	</table>
	</div>
</body>
</html>