package br.com.alura.jdbc.modelo;

public class Produto {
	private Integer id;
	private String nome;
	private String descricao;
	
	
	public Produto(String nomeArg, String descricaoArg) {
		super();
		this.nome = nomeArg;
		this.descricao = descricaoArg;
	}
	
	public Produto(Integer idArg, String nomeArg, String descricaoArg) {
		super();
		this.id = idArg;
		this.nome = nomeArg;
		this.descricao = descricaoArg;
	}
	

	public void setId(Integer id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public String getDescricao() {
		return descricao;
	}


	@Override
	public String toString() {
		return String.format("Produto é %d %s %s", this.id, this.nome, this.descricao);
	}
	
	
}
