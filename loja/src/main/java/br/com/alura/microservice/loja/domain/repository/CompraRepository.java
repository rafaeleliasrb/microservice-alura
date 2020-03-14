package br.com.alura.microservice.loja.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.alura.microservice.loja.domain.model.Compra;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Long> {

	public Optional<Compra> findByPedidoId(Long id);
}
