package br.com.alura.microservice.fornecedor.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.alura.microservice.fornecedor.domain.model.InfoForncedor;

@Repository
public interface InfoFornecedorRepository extends JpaRepository<InfoForncedor, Long> {

	public InfoForncedor getByUf(String uf);
}
