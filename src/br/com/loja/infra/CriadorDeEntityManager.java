package br.com.loja.infra;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.ComponentFactory;
import br.com.caelum.vraptor.ioc.RequestScoped;

@Component
@RequestScoped
public class CriadorDeEntityManager implements ComponentFactory<EntityManager> {

	private final EntityManagerFactory factory;
	private EntityManager entityManager;

	public CriadorDeEntityManager(EntityManagerFactory factory) {
		this.factory = factory;
	}
	
	@PostConstruct
	public void abreSessao() {
		entityManager = factory.createEntityManager();
	}
	
	@Override
	public EntityManager getInstance() {
		return entityManager;
	}
	
	@PreDestroy
	public void fechaSessao() {
		entityManager.close();
	}

}
