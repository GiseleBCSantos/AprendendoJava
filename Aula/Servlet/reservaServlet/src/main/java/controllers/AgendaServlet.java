package controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Agenda;
import models.AgendaDao;


@WebServlet(urlPatterns = {"/main_agenda", "/insert_agenda"})
public class AgendaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AgendaDao dao = new AgendaDao();

	public AgendaServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());

		String action = request.getServletPath();
		
		if (action.equals("/main_agenda")) {
			try {
				obterContatos(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (action.equals("/insert_agenda")) {
			novoContato(request, response);
		} else {
			response.sendRedirect("index.html");
		}
	}

	protected void obterContatos(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		response.sendRedirect("agenda.jsp");
		ArrayList<Agenda> lista = (ArrayList<Agenda>) dao.list_all();
		request.setAttribute("contatos",  lista);
		RequestDispatcher rd = request.getRequestDispatcher("agenda.jsp");
		rd.forward(request, response);
	}
	
	protected void novoContato(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Agenda agenda = new Agenda();
		agenda.setNome(request.getParameter("nome"));
		agenda.setFone(request.getParameter("telefone"));
		agenda.setEmail(request.getParameter("email"));
		dao.add(agenda);
		response.sendRedirect("main");
	}
}
