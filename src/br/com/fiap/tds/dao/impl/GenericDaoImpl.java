package br.com.fiap.tds.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.tds.dao.GenericDao;
import br.com.fiap.tds.exception.CommitException;
import br.com.fiap.tds.exception.EntityNotFounfException;

public abstract class GenericDaoImpl<E, K> implements GenericDao<E, K> {
	
	protected EntityManager em;
	
	private Class<E> clazz;
	
	@SuppressWarnings("all")
	public GenericDaoImpl(EntityManager em) {
		this.em = em;
		this.clazz = (Class<E>) ((ParameterizedType)
						getClass().getGenericSuperclass())
						.getActualTypeArguments()[0];
	}
	
	@Override
	public void create(E entidade) {
		em.persist(entidade);
	}

	@Override
	public E read(K id) throws EntityNotFounfException {
		E entidade = em.find(clazz, id);
		if(entidade == null)
			throw new EntityNotFounfException();
		return entidade;
	}

	@Override
	public void update(E entidade) {

		em.merge(entidade);
		
	}

	@Override
	public void delete(K id) throws EntityNotFounfException {
		E entidade = read(id);
		em.remove(entidade);
		
	}

	@Override
	public void commit() throws CommitException {
		try {
			em.getTransaction().begin();
			em.getTransaction().commit();
		} catch(Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			throw new CommitException();
		}
		
	}
	
	@Override
	public List<E> findAll(){
		TypedQuery<E> query = em.createQuery("from " + clazz.getName(), clazz);
		//Configurar o máximo de resultado
		query.setMaxResults(10);
		return query.getResultList();
	}
	
	@Override
	public List<E> listar(int primeiraPosicao, int maximoResultado) {
		return em.createQuery("from " + clazz.getName(), clazz)
				.setFirstResult(primeiraPosicao)
				.setMaxResults(maximoResultado)
				.getResultList();
	}

}
