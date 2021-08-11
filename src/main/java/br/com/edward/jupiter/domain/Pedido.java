package br.com.edward.jupiter.domain;

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
	
	public Pedido() {
		this.id = ++count;
		this.status = EnumStatusPedido.ANDAMENTO;
		this.itens = new ArrayList<>();
	}
	
	public void addPerfume(Perfume perfume, Integer quantidade) {
		this.itens.add(new ItemPedido(perfume, quantidade));
	}
}
