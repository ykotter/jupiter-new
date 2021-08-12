package br.com.edward.jupiter.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import br.com.edward.jupiter.domain.Pedido;

@Repository
public interface PedidoRepository {
	Pedido cadastrar(Pedido domain);
	Pedido remover(Pedido domain);
	List<Pedido> listar();
	Optional<Pedido> consultar(Long id);
}
