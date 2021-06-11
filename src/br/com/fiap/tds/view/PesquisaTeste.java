package br.com.fiap.tds.view;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.tds.dao.HotelDao;
import br.com.fiap.tds.dao.LoginDao;
import br.com.fiap.tds.dao.impl.HotelDaoImpl;
import br.com.fiap.tds.dao.impl.LoginDaoImpl;
import br.com.fiap.tds.entity.Hotel;
import br.com.fiap.tds.entity.Login;
import br.com.fiap.tds.singleton.EntityManagerFactorySingleton;

public class PesquisaTeste {

	public static void main(String[] args) {
		
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		//PESQUISA HOT�IS
		HotelDao hotelDao = new HotelDaoImpl(em);
		
		List<Hotel> hoteis = hotelDao.findAll();
		
		//1� PESQUISA JPQL
		hotelDao.buscarPorPrecoEEstado(200f, "S�o PAULO");
		System.out.println("Listar todos os hot�is por Estado e faixa de pre�o:");
		for (Hotel hotel: hoteis) {
			System.out.println(hotel.getNome() + " - " + hotel.getEndereco().getEstado() + " - " + hotel.getPreco());
		}
		
		//2� PESQUISA JPQL
		
		
		//3� PESQUISA JPQL
		LoginDao loginDao = new LoginDaoImpl(em);
		
		Login login = loginDao.buscarPorEmailESenha("gael@traveller.com.br", "@vamoscriptografar#");
		System.out.println("Exibir o login e senha cadastrado:");
		System.out.println(login.getEmail() + " - " + login.getSenha());
		
		em.close();
		EntityManagerFactorySingleton.getInstance().close();

	}

}
