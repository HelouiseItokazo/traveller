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
		
		//PESQUISA HOTÉIS
		HotelDao hotelDao = new HotelDaoImpl(em);
		
		List<Hotel> hoteis = hotelDao.findAll();
		
		//1º PESQUISA JPQL
		hotelDao.buscarPorPrecoEEstado(200f, "São PAULO");
		System.out.println("Listar todos os hotéis por Estado e faixa de preço:");
		for (Hotel hotel: hoteis) {
			System.out.println(hotel.getNome() + " - " + hotel.getEndereco().getEstado() + " - " + hotel.getPreco());
		}
		
		//2º PESQUISA JPQL
		
		
		//3º PESQUISA JPQL
		LoginDao loginDao = new LoginDaoImpl(em);
		
		Login login = loginDao.buscarPorEmailESenha("gael@traveller.com.br", "@vamoscriptografar#");
		System.out.println("Exibir o login e senha cadastrado:");
		System.out.println(login.getEmail() + " - " + login.getSenha());
		
		em.close();
		EntityManagerFactorySingleton.getInstance().close();

	}

}
