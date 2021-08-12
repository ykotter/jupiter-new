package br.com.edward.jupiter.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.edward.jupiter.domain.Perfume;
import br.com.edward.jupiter.model.PerfumeModel;
import br.com.edward.jupiter.repository.PerfumeRepository;
import br.com.edward.jupiter.service.PerfumeService;

@Service
public class PerfumeServiceImpl implements PerfumeService {

	@Autowired
	private PerfumeRepository perfumeRepository;
	
	@Override
	public Perfume cadastrar(final PerfumeModel model) {
		Perfume p = new Perfume(model.getNome(), model.getValor(), model.getTipo());
		return this.perfumeRepository.cadastrar(p);
	}

	@Override
	public Perfume alterar(final Long id, final PerfumeModel model) {
		Perfume p = this.consultar(id);
		return p.alterar(model.getNome(), model.getValor(), model.getTipo());
	}

	@Override
	public Perfume remover(final Long id) {
		return this.perfumeRepository.remover(this.consultar(id));
	}

	@Override
	public List<Perfume> listar() {
		return this.perfumeRepository.listar();
	}

	@Override
	public Perfume consultar(final Long id) {
		return this.perfumeRepository.consultar(id)
				.orElseThrow(() -> new RuntimeException("Perfume id " + id + " não existe."));
	}
}
