package com.alugueltech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alugueltech.entity.Cliente;
import com.alugueltech.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	ClienteRepository clienteRepository;

	public Object createCliente(Cliente cliente) {

		try {
			clienteRepository.save(cliente);
			return null;
		} catch (Exception e) {
			e.printStackTrace();
 			return null;
		}
	}

	public Cliente readCliente(Long idCliente) {

		try {
			Cliente cliente = clienteRepository.findByClienteId(idCliente);

			return cliente;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public Object updateCliente(Cliente cliente) {
		try {

			return clienteRepository.save(cliente);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Object deleteCliente(Long idCliente) {
		try {
			Cliente cliente = clienteRepository.findByClienteId(idCliente);
			clienteRepository.delete(cliente);
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<Cliente> readAllCliente() {

		List<Cliente> clienteList = clienteRepository.findAll();

		return clienteList;
	}

}
