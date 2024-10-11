<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="entities.Espaco" %>
<%@ page import="entities.Equipamento" %>
<%@ page import="entities.Funcionario" %>
<%@ page import="java.util.ArrayList" %>
<%
    ArrayList<Espaco> listaEspaco = (ArrayList<Espaco>) request.getAttribute("espacos");
    ArrayList<Equipamento> listaEquipamento = (ArrayList<Equipamento>) request.getAttribute("equipamentos");
    ArrayList<Funcionario> listaFuncionario = (ArrayList<Funcionario>) request.getAttribute("funcionarios");
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Adicionar Nova Reserva</title>
        <link rel="stylesheet" type="text/css" href="styles.css">
    
</head>
<body>
<div class="center-center-container pagina-criacao">
	<a href="index.html" class="botao-voltar"> <-- Voltar</a> 
    <h1>Adicionar nova reserva</h1>
    <form name="frmContato" action="insert_reserva" method="post">
    
                    <input type="date" name="data" required/>
               
                    <label for="funcionario">Selecione um funcionário:</label>
                    <select name="funcionario" id="funcionario" required>
                        <%
                        if (listaFuncionario != null && !listaFuncionario.isEmpty()) {
                            for (int i = 0; i < listaFuncionario.size(); i++) {
                        %>
                                <option value="<%= listaFuncionario.get(i).getNome() %>"><%= listaFuncionario.get(i).getNome() %></option>
                        <%
                            }
                        } else {
                        %>
                            <option disabled>Não há funcionários disponíveis</option>
                        <%
                        }
                        %>
                    </select>
             
	            <p>O que voce deseja reservar? </p>
	            
	            <div class="opcao-reserva">
	            
		            <table style="border:none;text-align:center">
		            	<tr>
		            		<td style="border:none;margin:0 10px;padding:0 10px"><input type="radio"  name="esp_equip" value="espaco" id="espaco_opcao" onclick="mostrarOpcoes()"/></td>
		            		<td style="border:none;margin:0 10px;padding:0 10px"><input type="radio"  name="esp_equip" value="equipamento" id="equipamento_opcao" onclick="mostrarOpcoes()"/></td>
		            	</tr>
		            	
		            	<tr>
		            		<td style="border:none;margin:0 10px;padding:0 10px"><label for="espaco_opcao">Espaco</label></td>
		            		<td style="border:none;margin:0 10px;padding:0 10px"><label for="equipamento_opcao">Equipamento</label></td>
		            	</tr>
		            
		            
		            </table>
					
        		</div>
			
			<div id="espaco" class="conteudo">
			
				
	                    <label for="espaco">Selecione um espaco:</label>
	                    <select name="espaco" id="espaco">
	                    <option></option>
	                        <%
	                        if (listaEspaco != null && !listaEspaco.isEmpty()) {
	                            for (int i = 0; i < listaEspaco.size(); i++) {
	                        %>
	                                <option value="<%= listaEspaco.get(i).getDescricao() %>"><%= listaEspaco.get(i).getDescricao() %></option>
	                        <%
	                            }
	                        } else {
	                        %>
	                            <option disabled>Não há espacos disponíveis</option>
	                        <%
	                        }
	                        %>
	                    </select>
	             
			</div>
			
			<div id="equipamento" class="conteudo">
				
	                    <label for="equipamento">Selecione um equipamento:</label>
	                    <select name="equipamento" id="equipamento">
	                    	<option></option>
	                    
	                        <%
	                        if (listaEquipamento != null && !listaEquipamento.isEmpty()) {
	                            for (int i = 0; i < listaEquipamento.size(); i++) {
	                        %>
	                                <option value="<%= listaEquipamento.get(i).getDescricao() %>"><%= listaEquipamento.get(i).getDescricao() %></option>
	                        <%
	                            }
	                        } else {
	                        %>
	                            <option disabled>Não há equipamentos disponíveis</option>
	                        <%
	                        }
	                        %>
	                    </select>
	            
			
			</div>
            
            
            
            
            
            
            
        </table>
        
        <input type="submit" value="Adicionar" class="botao-adicionar"/>
    </form>
    </div>
    <script>
    function mostrarOpcoes(){
    	var divs = document.querySelectorAll(".conteudo");
    	divs.forEach((div) => div.style.display = 'none')
    	
    	var selected = document.querySelector('input[name="esp_equip"]:checked');
    	console.log(selected.value)
    	if (selected){
    		var divId = selected.value;
    		document.getElementById(divId).style.display = 'block';
    	}
    }
    </script>
</body>
</html>
