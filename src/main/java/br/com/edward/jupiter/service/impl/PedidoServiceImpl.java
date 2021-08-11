package br.com.edward.jupiter.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.edward.jupiter.domain.Pedido;
import br.com.edward.jupiter.model.PedidoModel;
import br.com.edward.jupiter.repository.PedidoRepository;
import br.com.edward.jupiter.service.PedidoService;

public class PedidoServiceImpl implements PedidoService {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Override
	public Pedido cadastrar(PedidoModel model) {
		Pedido p = new Pedido();
		return p;
	}

	@Override
	public Pedido remover(Long id) {
		
		return this.pedidoRepository.remover(this.consultar(id));
	}

	@Override
	public List<Pedido> listar() {
		return this.pedidoRepository.listar();
	}

	@Override
	public Pedido consultar(Long id) {
		return this.pedidoRepository.consultar(id).orElseThrow(() -> new RuntimeException ("Não existe"));
	}

}
