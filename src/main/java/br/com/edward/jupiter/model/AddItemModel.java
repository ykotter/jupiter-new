package br.com.edward.jupiter.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class AddItemModel {
	
	private Long idPedido;
	private Long idProduto;
	private Integer qtd;
	
} 
