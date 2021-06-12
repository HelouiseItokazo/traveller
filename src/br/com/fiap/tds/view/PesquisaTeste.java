package br.com.fiap.tds.view;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.tds.dao.AvaliacaoDao;
import br.com.fiap.tds.dao.HotelDao;
import br.com.fiap.tds.dao.LoginDao;
import br.com.fiap.tds.dao.impl.AvaliacaoDaoImpl;
import br.com.fiap.tds.dao.impl.HotelDaoImpl;
import br.com.fiap.tds.dao.impl.LoginDaoImpl;
import br.com.fiap.tds.entity.Avaliacao;
import br.com.fiap.tds.entity.Hotel;
import br.com.fiap.tds.entity.Login;
import br.com.fiap.tds.enumeration.Tipo;
import br.com.fiap.tds.singleton.EntityManagerFactorySingleton;

public class PesquisaTeste {

	public static void main(String[] args) {
		
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		//PESQUISA HOT�IS
		HotelDao hotelDao = new HotelDaoImpl(em);
			
		//1� PESQUISA JPQL
		List<Hotel> hoteisPorEstadoEPreco = hotelDao.buscarPorPrecoEEstado(200f, "S�o PAULO");
		System.out.println("Listar todos os hot�is por Estado e faixa de pre�o:");
		for (Hotel hotel: hoteisPorEstadoEPreco) {
			System.out.println(hotel.getNome() + " - " + hotel.getEndereco().getEstado() + " - " + hotel.getPreco());
		}
	
		//2� PESQUISA JPQL
		List<Hotel> hoteisPorTipoEEstado = hotelDao.buscarPorTipoEEstado(Tipo.NEGOCIOS, "Rio de JANEIRO");
		System.out.println("Listar todos os hot�is por Estado e tipo:");
		for (Hotel hotel: hoteisPorTipoEEstado) {
			System.out.println(hotel.getNome() + " - " + hotel.getEndereco().getEstado() + " - " + hotel.getTipo() + " - " + hotel.getPreco());
		}
			
		//PESQUISAR POR AVALIACOES
		AvaliacaoDao avaliacaoDao = new AvaliacaoDaoImpl(em);
		
		//3� PESQUISA JPQL
		List<Avaliacao> avaliacoes = avaliacaoDao.buscarPorAvaliacao(1.0);
		System.out.println("Listar todos os hot�is por avalia��o:");
		for (Avaliacao avaliacao: avaliacoes) {
			System.out.println(avaliacao.getHotel().getNome() + " - " + avaliacao.getValor());
		}
		
		//PESQUISAR LOGIN
		LoginDao loginDao = new LoginDaoImpl(em);
		
		//4� PESQUISA JPQL
		Login login = loginDao.buscarPorEmailESenha("gael@traveller.com.br", "@vamoscriptografar#");
		System.out.println("Exibir o login e senha cadastrado:");
		System.out.println(login.getEmail() + " - " + login.getSenha());
		
		em.close();
		EntityManagerFactorySingleton.getInstance().close();

	}

}
