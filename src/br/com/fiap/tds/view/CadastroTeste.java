package br.com.fiap.tds.view;

import javax.persistence.EntityManager;

import br.com.fiap.tds.dao.AvaliacaoDao;
import br.com.fiap.tds.dao.EnderecoDao;
import br.com.fiap.tds.dao.HotelDao;
import br.com.fiap.tds.dao.LoginDao;
import br.com.fiap.tds.dao.TelefoneDao;
import br.com.fiap.tds.dao.impl.AvaliacaoDaoImpl;
import br.com.fiap.tds.dao.impl.EnderecoDaoImpl;
import br.com.fiap.tds.dao.impl.HotelDaoImpl;
import br.com.fiap.tds.dao.impl.LoginDaoImpl;
import br.com.fiap.tds.dao.impl.TelefoneDaoImpl;
import br.com.fiap.tds.entity.Avaliacao;
import br.com.fiap.tds.entity.Endereco;
import br.com.fiap.tds.entity.Hotel;
import br.com.fiap.tds.entity.Login;
import br.com.fiap.tds.entity.Telefone;
import br.com.fiap.tds.enumeration.Tipo;
import br.com.fiap.tds.enumeration.Uf;
import br.com.fiap.tds.exception.CommitException;
import br.com.fiap.tds.singleton.EntityManagerFactorySingleton;

public class CadastroTeste {
	
	public static void main(String[] args) {
				
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		//CADASTRAMENTO DE HOTEL COM ENDEREÇO E TELEFONE

		HotelDao hotelDao = new HotelDaoImpl(em);
		
		Endereco endereco = new Endereco("São Paulo", Uf.SP, "base64ImagemLocalização", 2.0f);
		Telefone telefone = new Telefone("11", "965933641");
		Hotel hotel = new Hotel("Paulista Center Hotel", "Café da manhã incluso na diária", Tipo.LAZER, "www.paulistacenterhotel.com.br", 200.00f, "base64ImagemHotel");
		
		endereco.addHotel(hotel);
		telefone.addHotel(hotel);
			
		hotelDao.create(hotel);
		
		Endereco endereco2 = new Endereco("Rio de Janeiro", Uf.RJ, "base64ImagemLocalização", 100.0f);
		Telefone telefone2 = new Telefone("21", "999999999");
		Hotel hotel2 = new Hotel("Copacabana Palace Hotel", "Café da manhã não está incluso na diária", Tipo.NEGOCIOS, "www.copacabanapalacehotel.com.br", 400.00f, "base64ImagemHotel");
		
		endereco2.addHotel(hotel2);
		telefone2.addHotel(hotel2);
		
		hotelDao.create(hotel2);
		
		Endereco endereco3 = new Endereco("São Paulo", Uf.SP, "base64ImagemLocalização", 3.0f);
		Telefone telefone3 = new Telefone("11", "988888888");
		Hotel hotel3 = new Hotel("Hotel Paulistano", "Café da manhã não está incluso na diária", Tipo.TRABALHO, "www.hotelpaulistano.com.br", 500.00f, "base64ImagemHotel");
		
		endereco3.addHotel(hotel3);
		telefone3.addHotel(hotel3);
		
		hotelDao.create(hotel3);
		
		//CADASTRAMENTO DE LOGIN
		LoginDao loginDao = new LoginDaoImpl(em);
		
		Login login = new Login("Gael", "@vamoscriptografar#", "gael@traveller.com.br", "admin");
		
		loginDao.create(login);
		
		//CADASTRAMENTO DE AVALIAÇÃO
		AvaliacaoDao avaliacaoDao = new AvaliacaoDaoImpl(em);
		
		Avaliacao avaliacao = new Avaliacao(3.0, "Super satisfeito");
		
		hotel.addAvaliacao(avaliacao);
		avaliacaoDao.create(avaliacao);
		
		Avaliacao avaliacao2 = new Avaliacao(2.0, "Satisfeito");
		
		hotel2.addAvaliacao(avaliacao2);
		avaliacaoDao.create(avaliacao2);
		
		Avaliacao avaliacao3 = new Avaliacao(1.0, "Insatisfeito");
		
		hotel3.addAvaliacao(avaliacao3);
		avaliacaoDao.create(avaliacao3);
		
		//COMO PARTILHAM O MESMO ENTITY MANAGER, OPTOU-SE POR UTILIZAR APENAS UM COMMIT
		try {
			hotelDao.commit();
			System.out.println("Cadastros efetuados com sucesso!");
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}
		
		em.close();
		EntityManagerFactorySingleton.getInstance().close();
		
	}
}
