package br.com.alura.gerenciador.acao;

import java.io.IOException;

import br.com.alura.gerenciador.modelo.Banco;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RemoveEmpresa implements Acao{

	public String executa(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		
		Banco banco = new Banco();
		banco.removeEmpresa(id);
		
		return "redirect:entrada?acao=ListaEmpresas";
		
	}

}
