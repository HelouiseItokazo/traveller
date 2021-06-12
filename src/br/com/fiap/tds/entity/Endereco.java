package br.com.fiap.tds.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.fiap.tds.enumeration.Uf;

@Entity
@Table(name="TB_ENDERECO")
@SequenceGenerator(name="seqEndereco", sequenceName="SEQ_TB_ENDERECO", allocationSize=1)
public class Endereco {
	
	@Id
	@Column(name="cd_endereco")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqEndereco")
	private Integer codigo;
	
	@Column(name="nm_estado", length = 30, nullable=false)
	private String estado;
	
	@Enumerated(EnumType.STRING)
	@Column(name="ds_uf", nullable=false)
	private Uf uf;
	
	@Column(name="img_localizacao", length = 1500, nullable=false)
	private String base64Imagem;
	
	@Column(name="vl_distancia", nullable=false)
	private Float distancia;
	
	@OneToMany(mappedBy = "endereco", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Hotel> hoteis;
	
	public void addHotel(Hotel hotel) {
		if (hoteis == null) {
			hoteis = new ArrayList<>();
		}

		hoteis.add(hotel);
		hotel.setEndereco(this); 
	}
	
	public Endereco() {}
	
	public Endereco(String estado, Uf uf, String base64Imagem, Float distancia) {
		this.estado = estado;
		this.uf = uf;
		this.base64Imagem = base64Imagem;
		this.distancia = distancia;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Uf getUf() {
		return uf;
	}

	public void setUf(Uf uf) {
		this.uf = uf;
	}

	public Float getDistancia() {
		return distancia;
	}

	public void setDistancia(Float distancia) {
		this.distancia = distancia;
	}

	public String getBase64Imagem() {
		return base64Imagem;
	}

	public void setBase64Imagem(String base64Imagem) {
		this.base64Imagem = base64Imagem;
	}

	public List<Hotel> getHoteis() {
		return hoteis;
	}

	public void setHoteis(List<Hotel> hoteis) {
		this.hoteis = hoteis;
	}
		
}
