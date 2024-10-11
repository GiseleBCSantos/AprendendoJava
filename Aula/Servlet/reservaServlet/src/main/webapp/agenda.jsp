<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="entities.Agenda" %>
<%@ page import="java.util.ArrayList" %>
<%
	ArrayList<Agenda> lista = (ArrayList<Agenda>) request.getAttribute("contatos");

	
%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<title>Agenda</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>Agenda de Contatos</h1>
	<a href="index.html">Voltar</a> <br>
	<a href="criarContato.html">Novo contato</a>
	
	<table class="tabela">
		<thead>
			<tr>
				<th>Id</th>
				<th>Nome</th>
				<th>Telefone</th>
				<th>E-mail</th>
			</tr>
		</thead>
		<tbody>
			<% for (int i = 0; i < lista.size(); i++) {%>
				<tr>
					<td><%= lista.get(i).getIdcon() %></td>
					<td><%= lista.get(i).getNome() %></td>
					<td><%= lista.get(i).getFone() %></td>
					<td><%= lista.get(i).getEmail() %></td>
					
				</tr>
			<%} %>
		</tbody>
	<tr>
	</tr>
	</table>
</body>
</html>