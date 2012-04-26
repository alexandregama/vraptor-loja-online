package br.com.loja.controller;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.SessionScoped;

@Component
@SessionScoped
public class Usuario {

	private String nome;
	
	public Usuario() {
		this.nome = "Alexandre";
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Usuario [nome=" + nome + "]";
	}
	
}
