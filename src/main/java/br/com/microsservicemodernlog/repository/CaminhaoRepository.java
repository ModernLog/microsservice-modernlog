package br.com.microsservicemodernlog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.microsservicemodernlog.model.Caminhao;

@Repository
public interface CaminhaoRepository extends JpaRepository<Caminhao, Long>{
	Caminhao findByModeloAndAno(String modelo, Integer ano);
}
