package br.com.edward.jupiter.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import br.com.edward.jupiter.enuns.EnumStatusPedido;
import lombok.Getter;

@Getter
public class Pedido {

	private static long count = 0;
	
	private Long id;
	private List<ItemPedido> itens;
	private EnumStatusPedido status;
	private Cliente cliente;
	private LocalDateTime dataPedido;
	private LocalDateTime dataPagamento;
	
	public Pedido(final Cliente cliente) {
		this.id = ++count;
		this.status = EnumStatusPedido.ANDAMENTO;
		this.itens = new ArrayList<>();
		this.cliente = cliente;
		this.dataPedido = LocalDateTime.now();
	}
	
	public void addPerfume(Perfume perfume, Integer quantidade) {
		if (EnumStatusPedido.PAGO.equals(this.status)) {
			throw new RuntimeException ("Pedido já pago");
		}
		this.itens.add(new ItemPedido(perfume, quantidade));
	}
	
	public BigDecimal getValorTotal() {
		BigDecimal soma = BigDecimal.ZERO;
		for (ItemPedido i : itens) {
			soma = soma.add(i.getValorTotal());
		} 
		return soma;
	}
	
	public EnumStatusPedido pagar() {
		if (this.getItens().isEmpty()) {
			throw new RuntimeException ("O pedido não tem itens");
		}
		this.status = EnumStatusPedido.PAGO;
		this.dataPagamento = LocalDateTime.now();
		return status;
	}
} 
