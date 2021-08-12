package br.com.edward.jupiter.repository.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import br.com.edward.jupiter.domain.Perfume;
import br.com.edward.jupiter.repository.PerfumeRepository;

@Repository
public class PerfumeRepositoryImpl implements PerfumeRepository {

	private final static List<Perfume> PERFUMES = new ArrayList<Perfume>();
	
	@Override
	public Perfume cadastrar(final Perfume domain) {
		PERFUMES.add(domain);
		return domain;
	}

	@Override
	public Perfume remover(final Perfume domain) {
		PERFUMES.remove(domain);
		return domain;
	}

	@Override
	public List<Perfume> listar() {
		return PERFUMES;
	}

	@Override
	public Optional<Perfume> consultar(final Long id) {
		return PERFUMES.stream().filter(p -> id.equals(p.getId())).findFirst();
	}
}
