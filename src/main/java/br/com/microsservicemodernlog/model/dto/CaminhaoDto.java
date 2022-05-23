package br.com.microsservicemodernlog.model.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CaminhaoDto {
	
	@NotBlank
	private String modelo;
	
	@NotNull
	private Integer ano;

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}
}
