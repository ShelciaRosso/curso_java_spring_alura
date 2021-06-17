package br.com.alura.jdbc.modelo;

import java.util.ArrayList;
import java.util.List;

public class Categoria {
	
	private Integer id;
	private String nome;
	private List<Produto> produtos = new ArrayList<Produto>();

	public Categoria(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	@Override
	public String toString() {
		return String.format("Categoria é %d %s", this.id, this.nome);
	}

	public void adicionar(Produto produto) {
		produtos.add(produto);
	}

	public List<Produto> getProdutos() {
		return produtos;
	}
	
	
	

}
