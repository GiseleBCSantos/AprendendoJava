package controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Equipamento;
import models.EquipamentoDao;


@WebServlet(urlPatterns = {"/main_equipamento", "/insertEquipamento"})
public class EquipamentoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EquipamentoDao equipamentoDao = new EquipamentoDao();

	public EquipamentoServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());

		String action = request.getServletPath();
		
		if (action.equals("/main_equipamento")) {
			try {
				obterContatos(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (action.equals("/insertEquipamento")) {
			novoEquipamento(request, response);
		} else {
			response.sendRedirect("index.html");
		}
	}

	protected void obterContatos(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		response.sendRedirect("agenda.jsp");
		ArrayList<Equipamento> lista = (ArrayList<Equipamento>) equipamentoDao.list_all();
		request.setAttribute("equipamentos",  lista);
		RequestDispatcher rd = request.getRequestDispatcher("equipamento.jsp");
		rd.forward(request, response);
	}
	
	protected void novoEquipamento(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Equipamento equipamento = new Equipamento();
		equipamento.setDescricao(request.getParameter("descricao"));
		equipamento.setQuantidadeDisponivel(Integer.valueOf(request.getParameter("quantidadeDisponivel")));
		equipamento.setQuantidadeTotal(Integer.valueOf(request.getParameter("quantidadeTotal")));
		equipamentoDao.add(equipamento);


		response.sendRedirect("main_equipamento");
	}
}
