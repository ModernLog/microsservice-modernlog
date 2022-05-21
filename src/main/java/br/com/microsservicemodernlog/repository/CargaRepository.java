package br.com.microsservicemodernlog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.microsservicemodernlog.model.Carga;

@Repository
public interface CargaRepository extends JpaRepository<Carga, Long>{
	Carga findByNotaFiscal(String nfe);
}
