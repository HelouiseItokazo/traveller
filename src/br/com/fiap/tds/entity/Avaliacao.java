package br.com.fiap.tds.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_AVALIACAO")
@SequenceGenerator(name="seqAvaliacao", sequenceName="SEQ_TB_AVALIACAO", allocationSize=1)
public class Avaliacao {
	
	@Id
	@Column(name="cd_avaliacao")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqAvaliacao")
	private Integer codigo;
	
	@Column(name="vl_avaliacao")
	private Double valor;
	
	@Column(name="ds_avaliacao", length = 100)
	private String descricao;
	
	@ManyToOne
	@JoinColumn(name = "cd_hotel", nullable = false)
	private Hotel hotel;
	
	public Avaliacao() {}
	
	public Avaliacao(Double valor, String descricao) {
		this.valor = valor;
		this.descricao = descricao;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	
}
