package br.com.loja.infra.teste;

import static org.junit.Assert.assertNotNull;

import javax.persistence.EntityManager;

import org.junit.Test;

import br.com.loja.infra.CriadorDeEntityManager;

public class HibernateTeste {
	
	@Test
	public void deveriaConectarNoBancoDeDadosConfiguradoNoPersistence() throws Exception {
		EntityManager entityManager = new CriadorDeEntityManager().getInstance();
		
		assertNotNull(entityManager);
	}

}
