package br.com.loja.repositorio.teste;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.Before;
import org.junit.Test;

import br.com.loja.builder.ProdutoBuilder;
import br.com.loja.modelo.Produto;
import br.com.loja.repositorio.RepositorioDeProdutos;

public class RepositorioDeProdutosTeste {

	private EntityManager entityManager;

	@Before
	public void criaEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("fj28");
		entityManager = entityManagerFactory.createEntityManager();
	}
	
	@Test
	public void deveriaInserirUmProdutoComNomeEPreco() throws Exception {
		removeTodosOsProdutos();
		
		BigDecimal preco = new BigDecimal(125);
		Produto novoProduto = new ProdutoBuilder().umProduto().chamado("Teclado").custando(preco).build();

		RepositorioDeProdutos repositorio = new RepositorioDeProdutos();
		repositorio.insere(novoProduto);
		
		Produto produto = buscaProduto();
		
		assertEquals("Teclado", produto.getNome());
		assertTrue(preco.compareTo(produto.getPreco()) == 0);
	}

	@Test
	public void deveriaModificarUmProdutoComNomeEPreco() throws Exception {
		removeTodosOsProdutos();
		
		BigDecimal preco = new BigDecimal(125);
		Produto novoProduto = new ProdutoBuilder().umProduto().chamado("Teclado").custando(preco).build();

		RepositorioDeProdutos repositorio = new RepositorioDeProdutos();
		repositorio.insere(novoProduto);
		
		Produto produto = buscaProduto();
		produto.setNome("Teclado com Mouse");
		BigDecimal novoPreco = new BigDecimal(185);
		produto.setPreco(novoPreco);
		
		repositorio.atualiza(produto);
		
		Produto produtoAtualizado = buscaProduto();
		
		assertEquals("Teclado com Mouse", produtoAtualizado.getNome());
		assertTrue(novoPreco.compareTo(produtoAtualizado.getPreco()) == 0);
	}
	
	private void removeTodosOsProdutos() {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		Query query = entityManager.createQuery("delete from Produto");
		query.executeUpdate();
		transaction.commit();
	}

	@SuppressWarnings("unchecked")
	private Produto buscaProduto() {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		Query query = entityManager.createQuery("from Produto");
		List<Produto> list = query.getResultList();
		transaction.commit();
		
		return  (Produto) list.get(0);
	}

}
