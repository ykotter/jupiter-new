package br.com.edward.jupiter.model;

import java.util.List;
import java.util.stream.Collectors;

import br.com.edward.jupiter.domain.Pedido;
import br.com.edward.jupiter.enuns.EnumStatusPedido;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class PedidoModel {
	private Long id;
	private EnumStatusPedido status;
	private List<ItemPedidoModel> itens;
	
	public PedidoModel(final Pedido domain) {
		this.id = domain.getId();
		this.itens = domain.getItens().stream().map(ItemPedidoModel::new).collect(Collectors.toList());
	}
}
