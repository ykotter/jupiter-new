package br.com.edward.jupiter.repository.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import br.com.edward.jupiter.domain.Pedido;
import br.com.edward.jupiter.repository.PedidoRepository;

public class PedidoRepositoryImpl implements PedidoRepository {
	
	private final static List<Pedido> PEDIDOS = new ArrayList<Pedido>();
	
	@Override
	public Pedido cadastrar(Pedido domain) {
		PEDIDOS.add(domain);
		return domain;
	}

	@Override
	public Pedido remover(Pedido domain) {
		PEDIDOS.remove(domain);
		return domain;
	}

	@Override
	public List<Pedido> listar() {
		return PEDIDOS;
	}

	@Override
	public Optional<Pedido> consultar(Long id) {
		return PEDIDOS.stream().filter(pe -> id.equals(pe.getId())).findFirst();
	}

}
