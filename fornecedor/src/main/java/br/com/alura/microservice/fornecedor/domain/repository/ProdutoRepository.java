package br.com.alura.microservice.fornecedor.domain.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.alura.microservice.fornecedor.domain.model.Produto;

@Repository
public interface ProdutoRepository extends CrudRepository<Produto, Long>{

	List<Produto> findByUf(String uf);
	
	List<Produto> findByIdIn(List<Long> ids);
}