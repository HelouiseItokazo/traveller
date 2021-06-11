package br.com.fiap.tds.dao;

import java.util.List;

import br.com.fiap.tds.entity.Avaliacao;
import br.com.fiap.tds.entity.Endereco;
import br.com.fiap.tds.entity.Hotel;

public interface HotelDao extends GenericDao<Hotel, Integer>{
	
	List<Hotel> buscarPorPrecoEEstado(float preco, String estado);
	
	List<Hotel> buscarPorAvaliacaoEEstado(Double avaliacao, String estado);

}
