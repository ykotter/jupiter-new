package br.com.edward.jupiter.model;

import br.com.edward.jupiter.domain.ItemPedido;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class ItemPedidoModel {
	
	private Long id;
	private PerfumeModel perfume;
	private Integer qtd;
	
	public ItemPedidoModel (final ItemPedido domain) {
		this.perfume = new PerfumeModel(domain.getPerfume());
		this.qtd = domain.getQtd();
		this.id = domain.getId();
	}
}
