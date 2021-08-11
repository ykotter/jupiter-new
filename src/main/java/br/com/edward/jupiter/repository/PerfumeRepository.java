package br.com.edward.jupiter.repository;

import java.util.List;
import java.util.Optional;

import br.com.edward.jupiter.domain.Perfume;

public interface PerfumeRepository {

	Perfume cadastrar(Perfume domain);
	Perfume remover(Perfume domain);
	List<Perfume> listar();
	Optional<Perfume> consultar(Long id);
}
