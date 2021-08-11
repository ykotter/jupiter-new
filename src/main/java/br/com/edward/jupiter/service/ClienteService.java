package br.com.edward.jupiter.service;

import java.util.List;

import br.com.edward.jupiter.domain.Cliente;
import br.com.edward.jupiter.model.ClienteModel;

public interface ClienteService {
	
	Cliente cadastrar(ClienteModel model);
	Cliente alterar(Long id, ClienteModel model);
	Cliente remover(Long id);
	List<Cliente> listar();
	Cliente consultar(Long id);
	Boolean isDocumentoValido(Long id);
	
}
