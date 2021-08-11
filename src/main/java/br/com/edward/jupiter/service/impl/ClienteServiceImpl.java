package br.com.edward.jupiter.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.edward.jupiter.domain.Cliente;
import br.com.edward.jupiter.model.ClienteModel;
import br.com.edward.jupiter.repository.ClienteRepository;
import br.com.edward.jupiter.service.ClienteService;


@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Override
	public Cliente cadastrar(final ClienteModel model) {
		Cliente c = new Cliente(model.getNome(), model.getDocumento());
		return this.clienteRepository.cadastrar(c);
	}


	@Override
	public Cliente remover(final Long id) {
		return this.clienteRepository.remover(this.consultar(id));
	}

	@Override
	public List<Cliente> listar() {
		return this.clienteRepository.listar();
	}

	@Override
	public Cliente consultar(final Long id) {
		return this.clienteRepository.consultar(id)
				.orElseThrow(() -> new RuntimeException("Perfume id " + id + " não existe."));
	}


	@Override
	public Cliente alterar(final Long id, final ClienteModel model) {
		Cliente c = this.consultar(id);
		return c.alterar(model.getNome(), model.getDocumento());
	}


	@Override
	public Boolean isDocumentoValido(Long id) {
		Cliente c = this.consultar(id);
		return c.isDocumentoValido();
	}
}
