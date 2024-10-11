<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="entities.Espaco" %>
<%@ page import="java.util.ArrayList" %>
<%
	ArrayList<Espaco> lista = (ArrayList<Espaco>) request.getAttribute("espacos");
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
	<h1>Lista de Espacos</h1>
	<a href="index.html" class="botao-voltar"> <-- Voltar</a> 
	<a href="criarEspaco.html">Novo espaco</a>
	
	<table class="tabela">
		<thead>
			<tr>
				<th>Id</th>
				<th>Descricao</th>
				<th>Status</th>
			</tr>
		</thead>
		<tbody>
			<% for (int i = 0; i < lista.size(); i++) {%>
				<tr>
					<td><%= lista.get(i).getId() %></td>
					<td><%= lista.get(i).getDescricao() %></td>
					<td><%= lista.get(i).isStatus() %></td>
					
				</tr>
			<%} %>
		</tbody>
	<tr>
	</tr>
	</table>
	</div>
</body>
</html>