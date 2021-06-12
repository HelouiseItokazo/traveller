package br.com.fiap.tds.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.tds.dao.AvaliacaoDao;
import br.com.fiap.tds.entity.Avaliacao;

public class AvaliacaoDaoImpl extends GenericDaoImpl<Avaliacao, Integer> implements AvaliacaoDao{

	public AvaliacaoDaoImpl(EntityManager em) {
		super(em);
	}
	
	@Override
	public List<Avaliacao> buscarPorAvaliacao(Double avaliacao) {
		return em.createQuery(
				"from Avaliacao a where a.valor = : av", Avaliacao.class)
				.setParameter("av", avaliacao)
				.getResultList();
	}

}
