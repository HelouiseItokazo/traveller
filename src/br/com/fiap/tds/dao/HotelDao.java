package br.com.fiap.tds.dao;

import java.util.List;

import br.com.fiap.tds.entity.Hotel;
import br.com.fiap.tds.enumeration.Tipo;

public interface HotelDao extends GenericDao<Hotel, Integer>{
	
	List<Hotel> buscarPorPrecoEEstado(float preco, String estado);
	
	List<Hotel> buscarPorTipoEEstado(Tipo tipo, String estado);
	
}
