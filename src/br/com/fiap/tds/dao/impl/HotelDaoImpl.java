package br.com.fiap.tds.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.tds.dao.HotelDao;
import br.com.fiap.tds.entity.Hotel;

public class HotelDaoImpl extends GenericDaoImpl<Hotel, Integer> implements HotelDao{

	public HotelDaoImpl(EntityManager em) {
		super(em);
	}

	@Override
	public List<Hotel> buscarPorPrecoEEstado(float preco, String estado) {
		return em.createQuery(
				"from Hotel h where lower(h.endereco.estado)  = lower(:est) and h.preco <= : p", Hotel.class)
				.setParameter("est", estado)
				.setParameter("p", preco)
				.getResultList();
	}

	@Override
	public List<Hotel> buscarPorAvaliacaoEEstado(Double avaliacao, String estado) {
		// TODO Auto-generated method stub
		return null;
	}



}
