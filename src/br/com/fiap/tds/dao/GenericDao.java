package br.com.fiap.tds.dao;

import java.util.List;

import br.com.fiap.tds.exception.CommitException;
import br.com.fiap.tds.exception.EntityNotFounfException;

public interface GenericDao<E, K> {
	
	void create(E entidade);
	
	E read(K id) throws EntityNotFounfException;
	
	void update(E entidade);
	
	void delete(K id) throws EntityNotFounfException;
	
	void commit() throws CommitException;
	
	List<E> findAll();
	
	List<E> listar(int primeiraPosicao, int maximoResultado);
}
