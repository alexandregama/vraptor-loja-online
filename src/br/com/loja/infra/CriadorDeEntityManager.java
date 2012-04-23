package br.com.loja.infra;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.ComponentFactory;

@Component
public class CriadorDeEntityManager implements ComponentFactory<EntityManager> {

	private static final String BANCO_DE_DADOS = "fj28";

	@Override
	public EntityManager getInstance() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(BANCO_DE_DADOS);
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		return entityManager;
	}

}
