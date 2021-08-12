package br.com.edward.jupiter.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.edward.jupiter.model.PerfumeModel;
import br.com.edward.jupiter.service.PerfumeService;

@RestController
@RequestMapping("/perfume")
public class PerfumeController {
	
	@Autowired
	private PerfumeService perfumeService;
	
	@PostMapping("/cadastrar")
	public PerfumeModel cadastrar(@RequestBody PerfumeModel model) {
		return new PerfumeModel(perfumeService.cadastrar(model));
	}
	
	@PutMapping("/alterar/{id}")
	public PerfumeModel alterar(@PathVariable Long id, @RequestBody PerfumeModel model) {
		return new PerfumeModel(perfumeService.alterar(id, model));
	}
	
	@DeleteMapping("/remover/{id}")
	public PerfumeModel remover(@PathVariable Long id) {
		return new PerfumeModel(perfumeService.remover(id));
	}
	
	@GetMapping("/listar")
	public List<PerfumeModel> listar() {
		return perfumeService.listar().stream().map(PerfumeModel::new).collect(Collectors.toList());
	}
}
