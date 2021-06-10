package br.com.fiap.tds.view;

import javax.persistence.EntityManager;

import br.com.fiap.tds.dao.AvaliacaoDao;
import br.com.fiap.tds.dao.EnderecoDao;
import br.com.fiap.tds.dao.LoginDao;
import br.com.fiap.tds.dao.TelefoneDao;
import br.com.fiap.tds.dao.impl.AvaliacaoDaoImpl;
import br.com.fiap.tds.dao.impl.EnderecoDaoImpl;
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
		EnderecoDao enderecoDao = new EnderecoDaoImpl(em);
		TelefoneDao telefoneDao = new TelefoneDaoImpl(em);
		
		Endereco endereco = new Endereco("São Paulo", Uf.SP, "base64ImagemLocalização", 2.0f);
		Telefone telefone = new Telefone("11", "965933641");
		Hotel hotel = new Hotel("Paulista Center Hotel", "Café da manhã incluso na diária", Tipo.LAZER, "www.paulistacenterhotel.com.br", 200.00f, "base64ImagemHotel");
		
		endereco.addHotel(hotel);
		telefone.addHotel(hotel);
		
		enderecoDao.create(endereco);
		telefoneDao.create(telefone);
		
		//CADASTRAMENTO DE LOGIN
		LoginDao loginDao = new LoginDaoImpl(em);
		
		Login login = new Login("Gael", "@vamoscriptografar#", "gael@traveller.com.br", "admin");
		
		loginDao.create(login);
		
		//CADASTRAMENTO DE AVALIAÇÃO
		AvaliacaoDao avaliacaoDao = new AvaliacaoDaoImpl(em);
		
		Avaliacao avaliacao = new Avaliacao(3.0, "Super satisfeito");
		
		hotel.addAvaliacao(avaliacao);
		
		avaliacaoDao.create(avaliacao);
		
		//COMO PARTILHAM O MESMO ENTITY MANAGER, OPTOU-SE POR UTILIZAR APENAS UM COMMIT
		try {
			enderecoDao.commit();
			System.out.println("Cadastros efetuados com sucesso!");
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}
		
		em.close();
		EntityManagerFactorySingleton.getInstance().close();
		
	}
}
