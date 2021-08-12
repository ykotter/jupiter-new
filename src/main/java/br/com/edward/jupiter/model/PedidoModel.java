package br.com.edward.jupiter.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
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
	private ClienteModel cliente;
	private LocalDateTime dataPedido;
	private LocalDateTime dataPagamento;
	private BigDecimal valorTotal;
	
	public PedidoModel(final Pedido domain) {
		this.id = domain.getId();
		this.itens = domain.getItens().stream().map(ItemPedidoModel::new).collect(Collectors.toList());
		this.status = domain.getStatus();
		this.cliente = new ClienteModel(domain.getCliente());
		this.dataPedido = domain.getDataPedido();
		this.dataPagamento = domain.getDataPagamento();
		this.valorTotal = domain.getValorTotal();
	}
}
