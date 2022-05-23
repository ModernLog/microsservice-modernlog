package br.com.microsservicemodernlog.model.dto;

import javax.validation.constraints.NotBlank;

public class CargaDto {

	@NotBlank
	private String descricao;
	
	@NotBlank
	private String notaFiscal;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getNotaFiscal() {
		return notaFiscal;
	}

	public void setNotaFiscal(String notaFiscal) {
		this.notaFiscal = notaFiscal;
	}
}
