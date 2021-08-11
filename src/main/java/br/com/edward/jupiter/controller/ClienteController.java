package br.com.edward.jupiter.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.edward.jupiter.model.ClienteModel;
import br.com.edward.jupiter.service.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@PostMapping("/cadastrar")
	public ClienteModel cadastrar(@Valid @RequestBody ClienteModel model, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
            throw new RuntimeException("Parametros incorretos.");
        }
		return new ClienteModel(clienteService.cadastrar(model));
	}
	
	@PutMapping("/alterar/{id}")
	public ClienteModel alterar(@PathVariable Long id, @Valid @RequestBody ClienteModel model, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
            throw new RuntimeException("Parametros incorretos.");
        }
		return new ClienteModel(clienteService.alterar(id, model));
	}
	
	@DeleteMapping("/remover/{id}")
	public ClienteModel remover(@PathVariable Long id) {
		return new ClienteModel(clienteService.remover(id));
	}
	
	@GetMapping("/listar")
	public List<ClienteModel> listar() {
		return clienteService.listar().stream().map(ClienteModel::new).collect(Collectors.toList());
	}
	
	@GetMapping("/validar/{id}")
	public Boolean validarCpf(@PathVariable Long id) {
		return clienteService.isDocumentoValido(id);
	}
}
