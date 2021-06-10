package br.com.fiap.tds.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_LOGIN")
@SequenceGenerator(name="seqLogin", sequenceName="SEQ_TB_LOGIN", allocationSize=1)
public class Login {
	
	@Id
	@Column(name="cd_usuario")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqLogin")
	private Integer codigo;
	
	@Column(name="nm_usuario", length = 20, nullable=false)
	private String nome;
	
	@Column(name="ds_senha", length = 1500, nullable=false)
	private String senha;
	
	@Column(name="ds_email", length = 50, nullable=false)
	private String email;
	
	@Column(name="ds_usuario", length = 25, nullable=false)
	private String descricao;
	
	public Login() {}

	public Login(String nome, String senha, String email, String descricao) {
		this.nome = nome;
		this.senha = senha;
		this.email = email;
		this.descricao = descricao;
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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
