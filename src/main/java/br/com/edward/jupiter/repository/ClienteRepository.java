package br.com.edward.jupiter.repository;

import java.util.List;
import java.util.Optional;

import br.com.edward.jupiter.domain.Cliente;

public interface ClienteRepository {
	
	Cliente cadastrar(Cliente domain);
	Cliente remover(Cliente domain);
	List<Cliente> listar();
	Optional<Cliente> consultar(Long id);
}
