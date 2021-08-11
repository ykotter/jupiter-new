package br.com.edward.jupiter.service;

import java.util.List;

import br.com.edward.jupiter.domain.Pedido;
import br.com.edward.jupiter.model.PedidoModel;

public interface PedidoService {
	Pedido cadastrar(PedidoModel model);
	Pedido remover(Long id);
	List<Pedido> listar();
	Pedido consultar(Long id);
}
