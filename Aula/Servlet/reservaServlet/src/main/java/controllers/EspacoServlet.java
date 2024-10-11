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
import entities.Espaco;
import models.EspacoDao;


@WebServlet(urlPatterns = {"/main_espaco", "/insert_espaco"})
public class EspacoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EspacoDao espacoDao = new EspacoDao();

	public EspacoServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		
		if (action.equals("/main_espaco")) {
			try {
				obterEspacos(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (action.equals("/insert_espaco")) {
			novoEspaco(request, response);
		} else {
			response.sendRedirect("index.html");
		}
	}

	protected void obterEspacos(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		response.sendRedirect("agenda.jsp");
		ArrayList<Espaco> lista = (ArrayList<Espaco>) espacoDao.list_all();
		request.setAttribute("espacos",  lista);
		RequestDispatcher rd = request.getRequestDispatcher("espaco.jsp");
		rd.forward(request, response);
	}
	
	protected void novoEspaco(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Espaco espaco = new Espaco();
		espaco.setDescricao(request.getParameter("descricao"));
		System.out.println(request.getParameter("status"));
		espaco.setStatus(request.getParameter("status") != null);
		System.out.println(espaco);
		try {
			espacoDao.add(espaco);
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("main_espaco");
	}
}
