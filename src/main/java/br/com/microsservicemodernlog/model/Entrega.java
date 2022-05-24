package br.com.microsservicemodernlog.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "tb_entrega")
public class Entrega {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(columnDefinition = "DATE")
	private LocalDate dataPrevisao;

	public Entrega() {
		
	}
	
	public Entrega(Long id, LocalDate dataPrevisao) {
		this.id = id;
		this.dataPrevisao = dataPrevisao;
	}

	public LocalDate getDataPrevisao() {
		return dataPrevisao;
	}

	public void setDataPrevisao(LocalDate dataPrevisao) {
		this.dataPrevisao = dataPrevisao;
	}
}
