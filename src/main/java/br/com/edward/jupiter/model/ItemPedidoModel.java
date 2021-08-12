package br.com.edward.jupiter.model;

import java.math.BigDecimal;

import br.com.edward.jupiter.domain.ItemPedido;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class ItemPedidoModel {
	
	private Long id;
	private PerfumeModel perfume;
	private Integer qtd;
	private BigDecimal valorTotal;
	
	public ItemPedidoModel (final ItemPedido domain) {
		this.perfume = new PerfumeModel(domain.getPerfume());
		this.qtd = domain.getQtd();
		this.id = domain.getId();
		this.valorTotal = domain.getValorTotal();
	}
}
