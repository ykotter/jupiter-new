package br.com.edward.jupiter.model;

import br.com.edward.jupiter.domain.Cliente;
import lombok.Getter;

@Getter
public class ClienteModel {
	
	private Long id;
	
	private String nome;
	
	private String documento;
	
	public ClienteModel() {}
	
	public ClienteModel(final Cliente domain) {
		this.nome = domain.getNome();
		this.documento = domain.getDocumento();
		this.id = domain.getId();
	}
}
