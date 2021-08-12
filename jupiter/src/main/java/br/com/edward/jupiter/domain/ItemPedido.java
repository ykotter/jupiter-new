package br.com.edward.jupiter.domain;

import java.math.BigDecimal;

import lombok.Getter;

@Getter
public class ItemPedido {
	
	private static long count = 0;
	
	private Long id;
	private Perfume perfume;
	private Integer qtd;
	
	public ItemPedido(Perfume perfume, Integer qtd) {
		this.perfume = perfume;
		this.qtd = qtd;
		this.id = ++count;
	}
	
	public BigDecimal getValorTotal() {
		return perfume.getValor().multiply(BigDecimal.valueOf(qtd));
	}
}
