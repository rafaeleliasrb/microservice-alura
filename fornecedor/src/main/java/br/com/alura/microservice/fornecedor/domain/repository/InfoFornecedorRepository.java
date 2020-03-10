package br.com.alura.microservice.fornecedor.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.alura.microservice.fornecedor.domain.model.InfoFornecedor;

@Repository
public interface InfoFornecedorRepository extends JpaRepository<InfoFornecedor, Long> {

	public InfoFornecedor getByUf(String uf);
}
