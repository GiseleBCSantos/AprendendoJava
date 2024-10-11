package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Equipamento;
import entities.Espaco;
import entities.Funcionario;
import entities.Reserva;
import models.EquipamentoDao;
import models.EspacoDao;
import models.FuncionarioDao;
import models.ReservaDao;

@WebServlet(urlPatterns= {"/main_reserva", "/nova_reserva", "/insert_reserva"})
public class ReservaServlet extends HttpServlet{
	ReservaDao reservaDao = new ReservaDao();
	EquipamentoDao equipamentoDao = new EquipamentoDao();
	EspacoDao espacoDao = new EspacoDao();
	FuncionarioDao funcionarioDao = new FuncionarioDao();
	
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		
		if (action.equals("/main_reserva")) {
			try {
				obterReservas(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (action.equals("/nova_reserva")) {
			try {
				irPaginaNovaReserva(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (action.equals("/insert_reserva")) {
			try {
				novaReserva(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			response.sendRedirect("index.html");
		}
	}

	protected void obterReservas(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ArrayList<Reserva> lista = (ArrayList<Reserva>) reservaDao.list_all();
		request.setAttribute("reservas",  lista);
		RequestDispatcher rd = request.getRequestDispatcher("reserva.jsp");
		rd.forward(request, response);
	}
	
	protected void irPaginaNovaReserva(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ArrayList<Espaco> listaEspaco = (ArrayList<Espaco>) espacoDao.list_all();
		request.setAttribute("espacos",  listaEspaco);
		ArrayList<Equipamento> listaEquipamento = (ArrayList<Equipamento>) equipamentoDao.list_all();
		request.setAttribute("equipamentos",  listaEquipamento);
		ArrayList<Funcionario> listaFuncionarios = (ArrayList<Funcionario>) funcionarioDao.list_all();
		request.setAttribute("funcionarios",  listaFuncionarios);
		
		RequestDispatcher rd = request.getRequestDispatcher("criarReserva.jsp");
		rd.forward(request, response);
		response.sendRedirect("criarReserva.jsp");
		
	}
	
	protected void novaReserva(HttpServletRequest request, HttpServletResponse response) throws Exception {		
		Reserva reserva = new Reserva();
		Equipamento equipamento = null;
		Espaco espaco = null;
		Funcionario funcionario = null;
		
		try {
			espaco = espacoDao.get_byDescricao(request.getParameter("espaco"));
			reserva.setEspaco(espaco);
		} catch (Exception e){ 
			equipamento= equipamentoDao.get_byDescricao(request.getParameter("equipamento"));
			reserva.setEquipamento(equipamento);
		} finally {
			funcionario= funcionarioDao.get_byNome(request.getParameter("funcionario"));

		}
		 

		reserva.setSolicitante(funcionario);
		reserva.setData(request.getParameter("data"));

		reservaDao.add(reserva);
		
		response.sendRedirect("main_reserva");
	}

}
