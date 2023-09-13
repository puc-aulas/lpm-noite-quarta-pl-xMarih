package com.alugueltech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alugueltech.entity.Cliente;
import com.alugueltech.service.ClienteService;

@RestController
@RequestMapping("/client")
public class ClienteController {

	@Autowired
	private ClienteService clientService;

	@PostMapping(path = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
	private ResponseEntity<Object> createCliente(@RequestBody Cliente cliente) {
		try {
			return new ResponseEntity<Object>(clientService.createCliente(cliente), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping(path = "/read")
	private ResponseEntity<Object> readCliente(Long idCliente) {
		try {
			return new ResponseEntity<Object>(clientService.readCliente(idCliente), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping(path = "/readAll", produces = MediaType.APPLICATION_JSON_VALUE)
	private ResponseEntity<Object> readAllCliente() {
		try {
			return new ResponseEntity<Object>(clientService.readAllCliente(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping(path = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
	private ResponseEntity<Object> updateCliente(@RequestBody Cliente cliente) {

		try {
			return new ResponseEntity<Object>(clientService.updateCliente(cliente), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping(path = "/delete")
	private ResponseEntity<Object> deleteCliente(Long idCliente) {
		try {

			return new ResponseEntity<Object>(clientService.deleteCliente(idCliente), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
