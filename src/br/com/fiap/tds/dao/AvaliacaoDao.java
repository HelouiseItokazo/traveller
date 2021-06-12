package br.com.fiap.tds.dao;

import java.util.List;

import br.com.fiap.tds.entity.Avaliacao;

public interface AvaliacaoDao extends GenericDao<Avaliacao, Integer>{
	
	public List<Avaliacao> buscarPorAvaliacao(Double avaliacao);
}
