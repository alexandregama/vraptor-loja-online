package br.com.loja.jpa.teste;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

public class HibernateTeste {

	@Test
	public void deveriaConectarNoBancoDeDadosConfiguradoNoPersistence() throws Exception {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("fj28");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		assertNotNull(entityManager);
	}

}
