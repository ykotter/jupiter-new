package br.com.edward.jupiter.domain;

import java.math.BigDecimal;

import br.com.edward.jupiter.enuns.EnumTipoPerfume;
import lombok.Getter;

@Getter
public class Perfume {
	
	private static long count = 0;
	
	private Long id;
	private String nome;
	private BigDecimal valor;
	private EnumTipoPerfume tipo;
	
	public Perfume(String nome, BigDecimal valor, EnumTipoPerfume tipo) {
		this.id = ++count;
		this.nome = nome;
		this.valor = valor;
		this.tipo = tipo;
	}
	
	public Perfume alterar(String nome, BigDecimal valor, EnumTipoPerfume tipo) {
		this.nome = nome;
		this.valor = valor;
		this.tipo = tipo;
		return this;
	}
}
