package br.com.fiap.tds.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_TELEFONE")
@SequenceGenerator(name="seqTelefone", sequenceName="SEQ_TB_TELEFONE", allocationSize=1)
public class Telefone {
	
	@Id
	@Column(name="cd_telefone")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqTelefone")
	private Integer codigo;
	
	@Column(name="nr_telefone", length = 8)
	private String telefone;
	
	@Column(name="nr_ddd", length = 2, nullable=false)
	private String ddd;
	
	@Column(name="nr_celular", length = 9, nullable=false)
	private String celular;
	
	@Column(name="nr_tel_secundario", length = 8)
	private String telefoneSecundario;
	
	@OneToMany(mappedBy = "telefone", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
	private List<Hotel> hoteis;
	
	public void addHotel(Hotel hotel) {
		if (hoteis == null) {
			hoteis = new ArrayList<>();
		}
		hoteis.add(hotel);
		hotel.setTelefone(this); 
	}
	
	public Telefone() {}
	
	public Telefone(String ddd, String celular) {
		this.ddd = ddd;
		this.celular = celular;
	}

	public Telefone(String telefone, String ddd, String celular, String telefoneSecundario) {
		this.telefone = telefone;
		this.ddd = ddd;
		this.celular = celular;
		this.telefoneSecundario = telefoneSecundario;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getTelefoneSecundario() {
		return telefoneSecundario;
	}

	public void setTelefoneSecundario(String telefoneSecundario) {
		this.telefoneSecundario = telefoneSecundario;
	}

	public List<Hotel> getHoteis() {
		return hoteis;
	}

	public void setHoteis(List<Hotel> hoteis) {
		this.hoteis = hoteis;
	}
	
}
