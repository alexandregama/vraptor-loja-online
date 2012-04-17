package br.com.loja.infra;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CriadorDeSessao {

	private static final String BANCO_DE_DADOS = "fj28";

	public static EntityManager obtemSessao() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(BANCO_DE_DADOS);
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		return entityManager;
	}

}
