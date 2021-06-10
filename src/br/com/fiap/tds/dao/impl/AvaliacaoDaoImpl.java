package br.com.fiap.tds.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.tds.dao.AvaliacaoDao;
import br.com.fiap.tds.entity.Avaliacao;

public class AvaliacaoDaoImpl extends GenericDaoImpl<Avaliacao, Integer> implements AvaliacaoDao{

	public AvaliacaoDaoImpl(EntityManager em) {
		super(em);
	}

}
