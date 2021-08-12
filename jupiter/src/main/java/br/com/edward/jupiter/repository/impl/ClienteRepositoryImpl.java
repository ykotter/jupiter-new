package br.com.edward.jupiter.repository.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import br.com.edward.jupiter.domain.Cliente;
import br.com.edward.jupiter.repository.ClienteRepository;

@Repository
public class ClienteRepositoryImpl implements ClienteRepository {
	
	private final static List<Cliente> CLIENTES = new ArrayList<Cliente>();
	
	@Override
	public Cliente cadastrar(final Cliente domain) {
		CLIENTES.add(domain);
		return domain;
	}

	@Override
	public Cliente remover(final Cliente domain) {
		CLIENTES.remove(domain);
		return domain;
	}

	@Override
	public List<Cliente> listar() {
		return CLIENTES;
	}

	@Override
	public Optional<Cliente> consultar(final Long id) {
		return CLIENTES.stream().filter(c -> id.equals(c.getId())).findFirst();
	}
}
