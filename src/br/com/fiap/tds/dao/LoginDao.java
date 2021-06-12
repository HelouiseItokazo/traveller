package br.com.fiap.tds.dao;

import br.com.fiap.tds.entity.Login;

public interface LoginDao extends GenericDao<Login, Integer>{
	
	public Login buscarPorEmailESenha(String email, String senha);
}
