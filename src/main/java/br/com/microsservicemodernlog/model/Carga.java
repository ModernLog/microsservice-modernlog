package br.com.microsservicemodernlog.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "tb_carga")
public class Carga {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(length = 50)
	private String descricao;
	
	@Column(length = 44, unique = true)
	private String notaFiscal;
	
	public Carga() {
		
	}
	
	public Carga(Long id, String descricao, String notaFiscal) {
		this.id = id;
		this.descricao = descricao;
		this.notaFiscal = notaFiscal;
	}

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
