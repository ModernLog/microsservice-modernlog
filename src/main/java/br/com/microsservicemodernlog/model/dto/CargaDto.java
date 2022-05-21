package br.com.microsservicemodernlog.model.dto;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

public class CargaDto {

	@NotBlank
	@Length(max = 25)
	private String descricao;
	
	@NotBlank
	@Length(max = 44)
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
