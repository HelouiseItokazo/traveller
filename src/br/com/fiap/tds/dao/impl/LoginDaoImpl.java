package br.com.fiap.tds.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.tds.dao.LoginDao;
import br.com.fiap.tds.entity.Hotel;
import br.com.fiap.tds.entity.Login;

public class LoginDaoImpl extends GenericDaoImpl<Login, Integer> implements LoginDao{

	public LoginDaoImpl(EntityManager em) {
		super(em);
	}

	@Override
	public Login buscarPorEmailESenha(String email, String senha) {
		return em.createQuery(
				"from Login l where l.email  = : e and l.senha <= : s", Login.class)
				.setParameter("e", email)
				.setParameter("s", senha)
				.getSingleResult();
	}

}
