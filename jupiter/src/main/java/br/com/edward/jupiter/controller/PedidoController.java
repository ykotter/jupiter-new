package br.com.edward.jupiter.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.edward.jupiter.model.PedidoModel;
import br.com.edward.jupiter.service.PedidoService;

@RestController
@RequestMapping("/pedido")
public class PedidoController {
	
	@Autowired
	private PedidoService pedidoService;
	
	@PostMapping("/cadastrar/{id}")
	public PedidoModel cadastrar(@PathVariable Long id) {
		return new PedidoModel(pedidoService.cadastrar(id));
	}
	
	@PutMapping("/pagar/{id}")
	public PedidoModel pagar(@PathVariable Long id) {
		return new PedidoModel(pedidoService.pagar(id));
	}
	
	
	/*@PutMapping("/alterar/{id}")
	public PedidoModel alterar(@PathVariable Long id, @Valid @RequestBody PerfumeModel model) {
		return new PerfumeModel(perfumeService.alterar(id, model));
	}*/
	
	@DeleteMapping("/remover/{id}")
	public PedidoModel remover(@PathVariable Long id) {
		return new PedidoModel(pedidoService.remover(id));
	}
	
	@GetMapping("/listar")
	public List<PedidoModel> listar() {
		return pedidoService.listar().stream().map(PedidoModel::new).collect(Collectors.toList());
	}
}
