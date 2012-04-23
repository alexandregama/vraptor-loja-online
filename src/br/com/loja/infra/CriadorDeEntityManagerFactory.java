package br.com.loja.infra;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.caelum.vraptor.ioc.ApplicationScoped;
import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.ComponentFactory;

@Component
@ApplicationScoped
public class CriadorDeEntityManagerFactory implements ComponentFactory<EntityManagerFactory> {

	private static final String BANCO_DE_DADOS = "fj28";
	private EntityManagerFactory factory;
	
	@PostConstruct
	public void criaFactory() {
		System.out.println("Criando Factory");
		factory = Persistence.createEntityManagerFactory(BANCO_DE_DADOS);
	}
	
	@Override
	public EntityManagerFactory getInstance() {
		return factory;
	}
	
	@PreDestroy
	public void fechaFactory() {
		System.out.println("Fechando Factory");
		factory.close();
	}

}
