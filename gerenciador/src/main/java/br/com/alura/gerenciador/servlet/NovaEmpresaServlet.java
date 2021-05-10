package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;

/**
 * Servlet implementation class NovaEmpresaServlet
 */
@WebServlet("/novaEmpresa")
public class NovaEmpresaServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    
	protected void service(HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Cadastrando nova empresa");
		String nomdeEmpresa = request.getParameter("nome");
		PrintWriter out = response.getWriter();
		out.println("<html><body>Empresa " + nomdeEmpresa + " cadastrada com sucesso!<body><html>");
	}

}
