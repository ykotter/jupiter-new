package br.com.edward.jupiter.model;

import br.com.edward.jupiter.domain.ItemPedido;
import br.com.edward.jupiter.domain.Perfume;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class ItemPedidoModel {
	
	private Long id;
	private Perfume perfume;
	private Integer qtd;
	
	public ItemPedidoModel (final ItemPedido domain) {
		this.perfume = domain.getPerfume();
		this.qtd = domain.getQtd();
		this.id = domain.getId();
	}
}
