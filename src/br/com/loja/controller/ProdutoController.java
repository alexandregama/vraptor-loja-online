package br.com.loja.controller;

import java.util.List;

import br.com.caelum.vraptor.Resource;
import br.com.loja.modelo.Produto;
import br.com.loja.repositorio.RepositorioDeProdutos;

@Resource
public class ProdutoController {

	private final RepositorioDeProdutos repositorioDeProdutos;

	public ProdutoController(RepositorioDeProdutos repositorioDeProdutos) {
		this.repositorioDeProdutos = repositorioDeProdutos;
	}
	
	public void insere(Produto produto) {
		repositorioDeProdutos.insere(produto);
	}

	public void atualiza(Produto produto) {
		repositorioDeProdutos.atualiza(produto);
	}

	public Produto obtemPorId(Long id) {
		return repositorioDeProdutos.obtemPorId(id);
	}

	public List<Produto> lista() {
		return repositorioDeProdutos.listaTodos();
	}

}
