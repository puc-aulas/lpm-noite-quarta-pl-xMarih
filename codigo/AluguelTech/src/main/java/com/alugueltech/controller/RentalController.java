package com.alugueltech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alugueltech.entity.Rental;
import com.alugueltech.service.RentalService;

@RestController
@RequestMapping("/rental")
public class RentalController {

	@Autowired
	private RentalService rentalService;

	@PostMapping(path = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
	private ResponseEntity<Object> createRental(@RequestBody Rental Rental) {
		try {
			return new ResponseEntity<Object>(rentalService.createRental(Rental), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping(path = "/read")
	private ResponseEntity<Object> readRental(Long idRental) {
		try {
			return new ResponseEntity<Object>(rentalService.readRental(idRental), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping(path = "/readAll", produces = MediaType.APPLICATION_JSON_VALUE)
	private ResponseEntity<Object> readAllRental() {
		try {
			return new ResponseEntity<Object>(rentalService.readAllRental(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping(path = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
	private ResponseEntity<Object> updateRental(@RequestBody Rental Rental) {

		try {
			return new ResponseEntity<Object>(rentalService.updateRental(Rental), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping(path = "/delete")
	private ResponseEntity<Object> deleteRental(Long idRental) {
		try {

			return new ResponseEntity<Object>(rentalService.deleteRental(idRental), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
