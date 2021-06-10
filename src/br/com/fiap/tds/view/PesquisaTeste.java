package br.com.fiap.tds.view;

import javax.persistence.EntityManager;

import br.com.fiap.tds.singleton.EntityManagerFactorySingleton;

public class PesquisaTeste {

	public static void main(String[] args) {
		
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
	
		
		em.close();
		EntityManagerFactorySingleton.getInstance().close();

	}

}
