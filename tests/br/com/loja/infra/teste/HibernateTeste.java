package br.com.loja.infra.teste;

import static org.junit.Assert.assertNotNull;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.junit.Test;

import br.com.loja.infra.CriadorDeEntityManager;
import br.com.loja.infra.CriadorDeEntityManagerFactory;

public class HibernateTeste {


	private EntityManager entityManager;

	public HibernateTeste() {
		CriadorDeEntityManagerFactory criadorDeFactory = new CriadorDeEntityManagerFactory();
		criadorDeFactory.criaFactory();
		EntityManagerFactory factory = criadorDeFactory.getInstance();
		
		CriadorDeEntityManager criadorDeEntityManager = new CriadorDeEntityManager(factory);
		criadorDeEntityManager.abreSessao();
		
		entityManager = criadorDeEntityManager.getInstance();
	}
	
	@Test
	public void deveriaConectarNoBancoDeDadosConfiguradoNoPersistence() throws Exception {
		assertNotNull(entityManager);
	}

}
