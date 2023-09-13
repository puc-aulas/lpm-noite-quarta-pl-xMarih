package com.alugueltech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alugueltech.entity.Equipment;
import com.alugueltech.service.EquipmentService;

@RestController
@RequestMapping("/equipment")
public class EquipmentController {

	@Autowired
	private EquipmentService equipmentService;

	@PostMapping(path = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
	private ResponseEntity<Object> createEquipment(@RequestBody Equipment equipment) {
		try {
			return new ResponseEntity<Object>(equipmentService.createEquipment(equipment), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping(path = "/read")
	private ResponseEntity<Object> readEquipment(Long idEquipment) {
		try {
			return new ResponseEntity<Object>(equipmentService.readEquipment(idEquipment), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping(path = "/readAll", produces = MediaType.APPLICATION_JSON_VALUE)
	private ResponseEntity<Object> readAllEquipment() {
		try {
			return new ResponseEntity<Object>(equipmentService.readAllEquipment(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping(path = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
	private ResponseEntity<Object> updateEquipment(@RequestBody Equipment equipment) {

		try {
			return new ResponseEntity<Object>(equipmentService.updateEquipment(equipment), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping(path = "/delete")
	private ResponseEntity<Object> deleteEquipment(Long idEquipment) {
		try {

			return new ResponseEntity<Object>(equipmentService.deleteEquipment(idEquipment), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}