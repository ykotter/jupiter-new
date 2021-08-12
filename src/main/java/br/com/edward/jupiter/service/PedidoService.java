package br.com.edward.jupiter.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.edward.jupiter.domain.Pedido;
import br.com.edward.jupiter.model.AddItemModel;

@Service
public interface PedidoService {
	
	Pedido cadastrar(Long id);
	Pedido remover(Long id);
	List<Pedido> listar();
	Pedido consultar(Long id);
	Pedido pagar(Long id);
	Pedido adicionar(AddItemModel model);
}
