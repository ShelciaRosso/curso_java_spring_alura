package br.com.alura.loja_jpa.modelo;

import javax.persistence.Entity;

@Entity
public class Informatica extends Produto {

	private String marca;
	private Integer modelo;

	public Informatica() {
	}

	public Informatica(String marca, Integer modelo) {
		this.marca = marca;
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setAutor(String marca) {
		this.marca = marca;
	}

	public Integer getModelo() {
		return modelo;
	}

	public void setNumeroDePaginas(Integer modelo) {
		this.modelo = modelo;
	}

}
