package br.com.fiap.tds.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.tds.dao.LoginDao;
import br.com.fiap.tds.entity.Login;

public class LoginDaoImpl extends GenericDaoImpl<Login, Integer> implements LoginDao{

	public LoginDaoImpl(EntityManager em) {
		super(em);
	}

}
