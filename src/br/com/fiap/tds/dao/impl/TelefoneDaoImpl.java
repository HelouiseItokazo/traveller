package br.com.fiap.tds.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.tds.dao.TelefoneDao;
import br.com.fiap.tds.entity.Telefone;

public class TelefoneDaoImpl extends GenericDaoImpl<Telefone, Integer> implements TelefoneDao{

	public TelefoneDaoImpl(EntityManager em) {
		super(em);
	}

}
