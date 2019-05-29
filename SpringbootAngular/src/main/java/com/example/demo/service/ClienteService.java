package com.example.demo.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Cliente;
import com.example.demo.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	ClienteRepository clienteRepository;
	
	
	public Cliente cadastrar(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	public Collection<Cliente> buscarTodos() {
		return clienteRepository.findAll();
	}

	public void excluir(Optional<Cliente> clienteEncontrado) {
		clienteRepository.deleteById(clienteEncontrado.get().getId());
	}

	public Optional<Cliente> buscarPorId(Integer id) {
		return clienteRepository.findById(id);
	}
	
	public Cliente alterar(Cliente cliente) {
		return clienteRepository.save(cliente);
	}
}
