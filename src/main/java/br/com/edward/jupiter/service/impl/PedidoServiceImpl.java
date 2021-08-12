package br.com.edward.jupiter.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.edward.jupiter.domain.Cliente;
import br.com.edward.jupiter.domain.Pedido;
import br.com.edward.jupiter.domain.Perfume;
import br.com.edward.jupiter.model.AddItemModel;
import br.com.edward.jupiter.repository.PedidoRepository;
import br.com.edward.jupiter.service.ClienteService;
import br.com.edward.jupiter.service.PedidoService;
import br.com.edward.jupiter.service.PerfumeService;

@Service
public class PedidoServiceImpl implements PedidoService {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	@Autowired
	private ClienteService clienteService;
	@Autowired
	private PerfumeService perfumeService;
	
	@Override
	public Pedido cadastrar(final Long id) {
		Cliente cliente = clienteService.consultar(id);
		Pedido pedido = new Pedido(cliente);
		return this.pedidoRepository.cadastrar(pedido);
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

	@Override
	public Pedido pagar(Long id) {
		Pedido p = this.consultar(id);
		p.pagar();
		return p;
	}

	@Override
	public Pedido adicionar(final AddItemModel model) {
		Perfume perfume = perfumeService.consultar(model.getIdProduto());
		Pedido p = this.consultar(model.getIdPedido());
		p.addPerfume(perfume, model.getQtd());
		return p;
	}
}
