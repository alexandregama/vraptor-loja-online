package br.com.loja.infra.teste;

import static org.junit.Assert.assertNotNull;

import javax.persistence.EntityManager;

import org.junit.Test;

import br.com.loja.infra.CriadorDeSessao;

public class HibernateTeste {

	@Test
	public void deveriaConectarNoBancoDeDadosConfiguradoNoPersistence() throws Exception {
		EntityManager entityManager = CriadorDeSessao.obtemSessao();
		
		assertNotNull(entityManager);
	}

}
