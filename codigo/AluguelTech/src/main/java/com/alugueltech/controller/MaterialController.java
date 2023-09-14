package com.alugueltech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alugueltech.entity.Material;
import com.alugueltech.service.MaterialService;

@RestController
@RequestMapping("/material")
public class MaterialController {

	@Autowired
	private MaterialService materialService;

	@PostMapping(path = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
	private ResponseEntity<Object> createMaterial(@RequestBody Material material) {
		try {
			return new ResponseEntity<Object>(materialService.createMaterial(material), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping(path = "/read")
	private ResponseEntity<Object> readMaterial(@RequestParam Long idMaterial) {
		try {
			return new ResponseEntity<Object>(materialService.readMaterial(idMaterial), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping(path = "/readAll", produces = MediaType.APPLICATION_JSON_VALUE)
	private ResponseEntity<Object> readAllMaterial() {
		try {
			return new ResponseEntity<Object>(materialService.readAllMaterial(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping(path = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
	private ResponseEntity<Object> updateMaterial(@RequestBody Material material) {

		try {
			return new ResponseEntity<Object>(materialService.updateMaterial(material), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping(path = "/delete")
	private ResponseEntity<Object> deleteMaterial(@RequestParam Long idMaterial) {
		try {

			return new ResponseEntity<Object>(materialService.deleteMaterial(idMaterial), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
