package br.com.microsservicemodernlog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.microsservicemodernlog.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	Cliente findByCnpj(String cnpj);
}
