package br.com.microsservicemodernlog.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "tb_caminhao")
public class Caminhao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(length = 30)
	private String modelo;
	
	@Column(length = 10)
	private String placa;
	
	@Column(length = 4)
	private Integer ano;
	
	public Caminhao() {
		
	}
	
	public Caminhao(Long id, String modelo, String placa, Integer ano) {
		this.id = id;
		this.modelo = modelo;
		this.placa = placa;
		this.ano = ano;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}
}
