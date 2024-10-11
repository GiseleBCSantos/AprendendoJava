<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="entities.Equipamento" %>
<%@ page import="java.util.ArrayList" %>
<%
	ArrayList<Equipamento> lista = (ArrayList<Equipamento>) request.getAttribute("equipamentos");
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
	<a href="index.html" class="botao-voltar"> <-- Voltar</a>
	<h1>Lista de Equipamentos</h1>
	
	<a href="criarEquipamento.html">Novo equipamento</a>
	
	<table class="tabela">
		<thead>
			<tr>
				<th>Id</th>
				<th>Descricao</th>
				<th>Quantidade Disponivel</th>
				<th>Quantidade Total</th>
			</tr>
		</thead>
		<tbody>
			<% for (int i = 0; i < lista.size(); i++) {%>
				<tr>
					<td><%= lista.get(i).getId() %></td>
					<td><%= lista.get(i).getDescricao() %></td>
					<td><%= lista.get(i).getQuantidadeDisponivel() %></td>
					<td><%= lista.get(i).getQuantidadeTotal() %></td>
					
				</tr>
			<%} %>
		</tbody>
	<tr>
	</tr>
	</table>
	</div>
</body>
</html>