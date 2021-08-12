package br.com.edward.jupiter.domain;

import java.util.Objects;

import lombok.Getter;

@Getter
public class Cliente {
	
	private static long count = 0;
	
	private String nome;
	private String documento;
	private Long id;
	
	public Cliente(String nome, String documento) {
		this.nome = nome;
		this.documento = documento;
		this.id = ++count;
	}
	
	public Cliente alterar(String nome, String documento) {
		this.nome = nome;
		this.documento = documento;
		return this;
	}
	
	public Boolean isDocumentoValido() {
		if (Objects.isNull(this.getDocumento())
				|| this.getDocumento().length() != 11) {
			return false;
		}
		Integer primeiroVerificador = 0;
		Integer segundoVerificador = 0;
		Integer soma = 0;
		Integer somaSegundo = 0;
		Integer j = 1;
		char[] arrayDoc = this.getDocumento().toCharArray();
		String[] arrayString = new String[arrayDoc.length];
		Integer[] digitosInt = new Integer[arrayDoc.length];

		for (int i = 0; i < arrayDoc.length-2; i++) {
			arrayString[i] = String.valueOf(arrayDoc[i]);
			digitosInt[i] = Integer.parseInt(arrayString[i]);
			soma += digitosInt[i] * j;
			j++;
		}
		primeiroVerificador = soma % 11;
		if (primeiroVerificador == 10) {
			primeiroVerificador = 0;
		}
		j = 0;
		for (int i = 0; i < arrayDoc.length-1; i++) {
			arrayString[i] = String.valueOf(arrayDoc[i]);
			digitosInt[i] = Integer.parseInt(arrayString[i]);
			somaSegundo += digitosInt[i] * j;
			j++;
		}
		segundoVerificador = somaSegundo % 11;
		if (segundoVerificador == 10) {
			segundoVerificador = 0;
		}

		for (int i = 0; i < digitosInt.length; i++) {
			arrayString[i] = String.valueOf(arrayDoc[i]);
		}
		if (primeiroVerificador.equals(Integer.parseInt(arrayString[9])) && segundoVerificador.equals(Integer.parseInt(arrayString[10]))) {
			return true;
		}
		return false;
	}
}
