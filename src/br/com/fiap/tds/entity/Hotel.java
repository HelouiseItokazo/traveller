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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.fiap.tds.enumeration.Tipo;


@Entity
@Table(name="TB_HOTEL")
@SequenceGenerator(name="seqHotel", sequenceName="SEQ_TB_HOTEL", allocationSize=1)
public class Hotel {
	
	@Id
	@Column(name="cd_hotel")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqHotel")
	private Integer codigo;
	
	@Column(name="nm_hotel", length = 100, nullable=false)
	private String nome;
	
	@Column(name="ds_hotel", length = 1500, nullable=false)
	private String descricao;
	
	@Enumerated(EnumType.STRING)
	@Column(name="ds_tipo", nullable=false)
	private Tipo tipo;
	
	@Column(name="ds_site", length = 500, nullable=false)
	private String site;
	
	@Column(name="vl_preco", nullable=false)
	private Float preco;
	
	@Column(name="img_hotel", length = 1500, nullable=false)
	private String base64Imagem;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cd_telefone", nullable = false)
	private Telefone telefone;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cd_endereco", nullable = false)
	private Endereco endereco;
	
	@OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Avaliacao> avaliacoes;
	
	public void addAvaliacao(Avaliacao avaliacao) {
		if (avaliacoes == null) {
			avaliacoes = new ArrayList<>();
		}
		avaliacoes.add(avaliacao);
		avaliacao.setHotel(this); 
	}

	public Hotel() {}
	
	public Hotel(String nome, String descricao, Tipo tipo, String site, Float preco, String base64Imagem) {
		this.nome = nome;
		this.descricao = descricao;
		this.tipo = tipo;
		this.site = site;
		this.preco = preco;
		this.base64Imagem = base64Imagem;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public Float getPreco() {
		return preco;
	}

	public void setPreco(Float preco) {
		this.preco = preco;
	}

	public String getBase64Imagem() {
		return base64Imagem;
	}

	public void setBase64Imagem(String base64Imagem) {
		this.base64Imagem = base64Imagem;
	}

	public Telefone getTelefone() {
		return telefone;
	}

	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public List<Avaliacao> getAvaliacoes() {
		return avaliacoes;
	}

	public void setAvaliacoes(List<Avaliacao> avaliacoes) {
		this.avaliacoes = avaliacoes;
	}

}
