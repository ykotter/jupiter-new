package br.com.edward.jupiter.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.edward.jupiter.domain.Perfume;
import br.com.edward.jupiter.model.PerfumeModel;

@Service
public interface PerfumeService {
	
	Perfume cadastrar(PerfumeModel model);
	Perfume alterar(Long id, PerfumeModel model);
	Perfume remover(Long id);
	List<Perfume> listar();
	Perfume consultar(Long id);
}
