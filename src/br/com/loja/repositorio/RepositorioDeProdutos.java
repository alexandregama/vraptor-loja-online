package br.com.loja.repositorio;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import br.com.caelum.vraptor.ioc.Component;
import br.com.loja.infra.CriadorDeSessao;
import br.com.loja.modelo.Produto;

@Component
public class RepositorioDeProdutos {

	private EntityManager entityManager;

	public RepositorioDeProdutos() {
		entityManager = CriadorDeSessao.obtemSessao();
	}
	
	public void insere(Produto produto) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(produto);
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

	@SuppressWarnings("unchecked")
	public List<Produto> listaTodos() {
		Query query = entityManager.createQuery("from Produto");
		
		return query.getResultList();
	}

	public void remove(Produto produto) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.remove(produto);
		transaction.commit();
	}
	
}
