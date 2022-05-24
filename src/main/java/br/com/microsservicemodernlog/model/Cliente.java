package br.com.microsservicemodernlog.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.br.CNPJ;

@Entity(name = "tb_cliente")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(length = 30)
	private String razaoSocial;

	@Column(length = 14, unique = true)
	private String cnpj;

	@Column(length = 17, unique = true)
	private String telefone;

	public Cliente() {

	}

	public Cliente(Long id, String razaoSocial, @CNPJ String cnpj, String telefone) {
		this.id = id;
		this.razaoSocial = razaoSocial;
		this.cnpj = cnpj;
		this.telefone = telefone;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
}
