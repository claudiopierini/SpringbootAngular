package com.example.demo.resource;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Cliente;
import com.example.demo.service.ClienteService;

@RestController
public class ClienteController {

	@Autowired
	ClienteService clienteService;
	
	@PostMapping("/clientes")
	public ResponseEntity<Cliente> cadastrarClientes(@RequestBody Cliente cliente) {
		Cliente clienteCadastrado = clienteService.cadastrar(cliente);
		return new ResponseEntity<>(clienteCadastrado, HttpStatus.CREATED);
	}

	@GetMapping("/clientes")
	public ResponseEntity<Collection<Cliente>> buscarTodosClientes() {
		Collection<Cliente> clientesBuscados = clienteService.buscarTodos();
		return new ResponseEntity<>(clientesBuscados, HttpStatus.OK);
	}

	@DeleteMapping("/clientes/{id}")
	public ResponseEntity<Cliente> excluirClientes(@PathVariable Integer id) {
		Optional<Cliente> clienteEncontrado = clienteService.buscarPorId(id);

		if (clienteEncontrado == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		clienteService.excluir(clienteEncontrado);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PutMapping("/clientes")
	public ResponseEntity<Cliente> atualizarClientes(@RequestBody Cliente cliente) {
		Cliente clienteAlterado = clienteService.alterar(cliente);
		return new ResponseEntity<>(clienteAlterado, HttpStatus.OK);
	}

}
