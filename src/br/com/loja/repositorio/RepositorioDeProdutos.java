package br.com.loja.repositorio;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import br.com.loja.modelo.Produto;

public class RepositorioDeProdutos {

	private EntityManager entityManager;

	public RepositorioDeProdutos() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("fj28");
		entityManager = factory.createEntityManager();
	}
	
	public void insere(Produto novoProduto) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(novoProduto);
		transaction.commit();
	}

	public void atualiza(Produto produto) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.merge(produto);
		transaction.commit();
	}

	public Produto obtemPorId(Long id) {
		Produto produto = entityManager.find(Produto.class, id);
		
		return produto;
	}
	
}
