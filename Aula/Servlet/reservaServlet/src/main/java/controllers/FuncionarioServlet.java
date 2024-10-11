package controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Funcionario;
import javax.servlet.http.HttpServlet;
import models.FuncionarioDao;

@WebServlet(urlPatterns= {"/main_funcionario", "/insert_funcionario"})
public class FuncionarioServlet extends HttpServlet{
	FuncionarioDao funcionarioDao = new FuncionarioDao();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		
		if (action.equals("/main_funcionario")) {
			try {
				obterFuncionarios(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (action.equals("/insert_funcionario")) {
			novoEspaco(request, response);
		} else {
			response.sendRedirect("index.html");
		}
	}

	protected void obterFuncionarios(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ArrayList<Funcionario> lista = (ArrayList<Funcionario>) funcionarioDao.list_all();
		request.setAttribute("funcionarios",  lista);
		RequestDispatcher rd = request.getRequestDispatcher("funcionario.jsp");
		rd.forward(request, response);
	}
	
	protected void novoEspaco(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Funcionario funcionario = new Funcionario();
		funcionario.setNome(request.getParameter("nome"));
		funcionario.setEmail(request.getParameter("email"));
		System.out.println(funcionario);
		try {
			funcionarioDao.add(funcionario);
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("main_funcionario");
	}

}
