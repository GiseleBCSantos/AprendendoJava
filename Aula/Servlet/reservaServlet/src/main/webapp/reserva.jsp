<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="entities.Reserva" %>
<%@ page import="java.util.ArrayList" %>
<%
    ArrayList<Reserva> lista = (ArrayList<Reserva>) request.getAttribute("reservas");
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
    <h1>Lista de reservas</h1>
    <a href="index.html" class="botao-voltar"> <-- Voltar</a> 
    <a href="nova_reserva">Nova reserva</a>
    
    <table class="tabela">
        <thead>
            <tr>
                <th>Id</th>
                <th>Data</th>
                <th>Solicitante</th>
                <th>Espaco</th>
                <th>Equipamento</th>
            </tr>
        </thead>
        <tbody>
            <%
                for (Reserva reserva : lista) {
            %>
                <tr>
                    <td><%= reserva.getId() %></td>
                    <td><%= reserva.getData() %></td>
                    <td><%= reserva.getSolicitante().getNome() %></td>
                    <td>
                        <%= reserva.getEspaco() != null ? reserva.getEspaco().getDescricao() : "-----" %>
                    </td>
                    <td>
                        <%= reserva.getEquipamento() != null ? reserva.getEquipamento().getDescricao() : "-----" %>
                    </td>
                </tr>
            <%
                }
            %>
        </tbody>
    </table>
</div>
</body>
</html>
