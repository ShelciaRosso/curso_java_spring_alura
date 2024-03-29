package br.com.alura.gerenciador.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Banco {
	
	private static List<Empresa> lista = new ArrayList<>();
	private static List<Usuario> listaUsuarios = new ArrayList<>();
	private static Integer chaveSequencial = 1;
	
	static {
		Empresa empresa = new Empresa();
		empresa.setId(Banco.chaveSequencial++);
		empresa.setNome("Alura");
		
		Empresa empresa2 = new Empresa();
		empresa2.setId(Banco.chaveSequencial++);
		empresa2.setNome("Caelum");
		
		Banco.lista.add(empresa);
		Banco.lista.add(empresa2);
		
		Usuario usuario = new Usuario();
		usuario.setLogin("Nico");
		usuario.setSenha("12345");
		
		Usuario usuario2 = new Usuario();
		usuario2.setLogin("Ana");
		usuario.setSenha("12345");
		
		Banco.listaUsuarios.add(usuario);
		Banco.listaUsuarios.add(usuario2);
	}

	public void adiciona(Empresa empresa) {
		empresa.setId(Banco.chaveSequencial++);
		Banco.lista.add(empresa);
	}
	
	public List<Empresa> getEmpresas(){
		return Banco.lista;
	}

	public void removeEmpresa(Integer id) {
		Iterator<Empresa> it = lista.iterator();
		
		while(it.hasNext()) {
			Empresa emp = it.next();
			
			if(emp.getId() == id){
				it.remove();
			}
		}
		
		// D� problema ao excluir todos os registros, usar iterator
//		for (Empresa empresa : lista) {
//			if(empresa.getId() == id){
//				lista.remove(empresa);
//			}
//		}
		
	}

	public Empresa buscaEmpresaPelaId(Integer id) {
		for (Empresa empresa : lista) {
			if(empresa.getId() == id){
				return empresa;
			}
		}
		
		return null;
	}

	public Usuario existeUsuario(String login, String senha) {
		for (Usuario usuario : listaUsuarios) {
			if(usuario.ehIgual(login, senha)){
				return usuario;
			}
		}
		
		return null;
		
	}

}
