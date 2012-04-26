package br.com.loja.repositorio.teste;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Matchers.*;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.junit.Before;
import org.junit.Test;

import static br.com.caelum.vraptor.util.test.MockResult.*;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.util.test.MockResult;
import br.com.caelum.vraptor.util.test.MockValidator;
import br.com.loja.builder.ProdutoBuilder;
import br.com.loja.controller.ProdutosController;
import br.com.loja.infra.CriadorDeEntityManager;
import br.com.loja.infra.CriadorDeEntityManagerFactory;
import br.com.loja.modelo.Produto;
import br.com.loja.repositorio.RepositorioDeProdutos;

public class ProdutosControllerTeste {

	private EntityManager entityManager;

	@Before
	public void criaEntityManager() {
		CriadorDeEntityManagerFactory criadorDeFactory = new CriadorDeEntityManagerFactory();
		criadorDeFactory.criaFactory();
		EntityManagerFactory factory = criadorDeFactory.getInstance();
		
		CriadorDeEntityManager criadorDeEntityManager = new CriadorDeEntityManager(factory);
		criadorDeEntityManager.abreSessao();
		
		entityManager = criadorDeEntityManager.getInstance();
	}
	
	@Test
	public void deveriaInserirUmProdutoComNomeEPreco() throws Exception {
		removeTodosOsProdutos();
		
		BigDecimal preco = new BigDecimal(125);
		Produto novoProduto = new ProdutoBuilder().umProduto().chamado("Teclado").custando(preco).build();

		MockResult result = new MockResult();
		Validator validator = new MockValidator();
		ProdutosController controller = new ProdutosController(result, validator, new RepositorioDeProdutos(entityManager));
		controller.adiciona(novoProduto);
		
		Produto produto = buscaProdutoInserido();
		
		assertEquals("Teclado", produto.getNome());
		assertTrue(preco.compareTo(produto.getPreco()) == 0);
	}

	@Test
	public void deveriaAtualizarUmProdutoComNomeEPreco() throws Exception {
		removeTodosOsProdutos();
		
		BigDecimal preco = new BigDecimal(125);
		Produto novoProduto = new ProdutoBuilder().umProduto().chamado("Teclado").custando(preco).build();

		MockResult result = new MockResult();
		Validator validator = new MockValidator();
		ProdutosController controller = new ProdutosController(result, validator, new RepositorioDeProdutos(entityManager));
		controller.adiciona(novoProduto);
		
		Produto produto = buscaProdutoInserido();
		produto.setNome("Teclado com Mouse");
		BigDecimal novoPreco = new BigDecimal(185);
		produto.setPreco(novoPreco);
		
		controller.atualiza(produto);
		
		Produto produtoAtualizado = buscaProdutoInserido();
		
		assertEquals("Teclado com Mouse", produtoAtualizado.getNome());
		assertTrue(novoPreco.compareTo(produtoAtualizado.getPreco()) == 0);
	}
	
	@Test
	public void deveriaRetornarUmProdutoPeloSeuId() throws Exception {
		removeTodosOsProdutos();
		
		BigDecimal preco = new BigDecimal(125);
		Produto novoProduto = new ProdutoBuilder().umProduto().chamado("Teclado").custando(preco).build();
		
		MockResult result = new MockResult();
		Validator validator = new MockValidator();
		ProdutosController controller = new ProdutosController(result, validator, new RepositorioDeProdutos(entityManager));
		controller.adiciona(novoProduto);
		
		Produto produtoCadastrado = buscaProdutoInserido();
		Long idGerado = produtoCadastrado.getId();
		
		Produto produto = controller.obtemPorId(idGerado);
		
		assertEquals(produto.getNome(), "Teclado");
		assertTrue(preco.compareTo(produto.getPreco()) == 0);
	}
	
	@Test
	public void deveriaListarTodosOsProdutosCadastrados() throws Exception {
		removeTodosOsProdutos();
		
		BigDecimal precoDoTeclado = new BigDecimal(125);
		Produto teclado = new ProdutoBuilder().umProduto().chamado("Teclado").custando(precoDoTeclado).build();
		BigDecimal precoDoMouse = new BigDecimal(25);
		Produto mouse = new ProdutoBuilder().umProduto().chamado("Mouse").custando(precoDoMouse).build();
		
		MockResult result = new MockResult();
		Validator validator = new MockValidator();
		ProdutosController controller = new ProdutosController(result, validator, new RepositorioDeProdutos(entityManager));
		controller.adiciona(teclado);
		controller.adiciona(mouse);
		
		List<Produto> produtos = controller.lista();
		
		assertEquals(2, produtos.size());
		assertEquals("Teclado", produtos.get(0).getNome());
		assertEquals("Mouse", produtos.get(1).getNome());
		assertTrue(precoDoTeclado.compareTo(produtos.get(0).getPreco()) == 0);
		assertTrue(precoDoMouse.compareTo(produtos.get(1).getPreco()) == 0);
	}

	@Test
	public void insereprodutosParaTeste() throws Exception {
		Produto teclado = new ProdutoBuilder().umProduto().chamado("Teclado").custando(new BigDecimal(125)).build();
		Produto mouse = new ProdutoBuilder().umProduto().chamado("Mouse").custando(new BigDecimal(25)).build();
		Produto penDrive = new ProdutoBuilder().umProduto().chamado("Pen Drive").custando(new BigDecimal(25)).build();
		
		MockResult result = new MockResult();
		Validator validator = new MockValidator();
		ProdutosController controller = new ProdutosController(result, validator, new RepositorioDeProdutos(entityManager));
		
		controller.adiciona(teclado);
		controller.adiciona(mouse);
		controller.adiciona(penDrive);
	}
	
	@Test
	public void deveriaEnviarOUsuarioParaAListaDeProdutosAposCadastroDeNovoProduto() throws Exception {
		Produto produto = mock(Produto.class);
		MockResult result = spy(new MockResult());
		RepositorioDeProdutos repositorio = mock(RepositorioDeProdutos.class);
		
		Validator validator = new MockValidator();
		ProdutosController controller = new ProdutosController(result, validator, repositorio);
		ProdutosController spyController = spy(controller);
		
		when(result.redirectTo(controller)).thenReturn(spyController);
		when(produto.getNome()).thenReturn("qualquer nome");
		
		controller.adiciona(produto);
		
		verify(spyController).lista();
	}

	private void removeTodosOsProdutos() {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		Query query = entityManager.createQuery("delete from Produto");
		query.executeUpdate();
		transaction.commit();
	}

	@SuppressWarnings("unchecked")
	private Produto buscaProdutoInserido() {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		Query query = entityManager.createQuery("from Produto");
		List<Produto> list = query.getResultList();
		transaction.commit();
		
		return  (Produto) list.get(0);
	}

}
