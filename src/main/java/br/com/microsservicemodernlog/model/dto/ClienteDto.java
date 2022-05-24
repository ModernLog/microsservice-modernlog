package br.com.microsservicemodernlog.model.dto;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.br.CNPJ;

public class ClienteDto {
	
	@NotBlank
	private String razaoSocial;
	
	@NotBlank
	@CNPJ
	private String cnpj;
	
	@NotBlank
	private String telefone;

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
