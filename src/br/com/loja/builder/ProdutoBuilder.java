package br.com.loja.builder;

import java.math.BigDecimal;

import br.com.loja.modelo.Produto;

public class ProdutoBuilder {

	private Produto produto;
	
	public ProdutoBuilder umProduto() {
		produto = new Produto();
		return this;
	}

	public ProdutoBuilder chamado(String nome) {
		produto.setNome(nome);
		return this;
	}

	public ProdutoBuilder custando(BigDecimal preco) {
		produto.setPreco(preco);
		return this;
	}

	public Produto build() {
		return produto;
	}
	
}
