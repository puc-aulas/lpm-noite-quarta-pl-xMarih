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

import com.alugueltech.entity.Rental;
import com.alugueltech.service.RentalService;
import com.alugueltech.vo.RentalVo;

@RestController
@RequestMapping("/rental")
public class RentalController {

	@Autowired
	private RentalService rentalService;

	@PostMapping(path = "/list-rental-by-client")
	private ResponseEntity<Object> listRentalByClient(Long clienteId) {
		try {
			return new ResponseEntity<Object>(rentalService.listRentalByClient(clienteId), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping(path = "/rental-calculator")
	private ResponseEntity<Object> rentalCalculatorlById(Long rentalId) {
		try {
			return new ResponseEntity<Object>(rentalService.rentalCalculatorlById(rentalId), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping(path = "/monthly-report")
	private ResponseEntity<Object> monthlyReport() {
		try {
			return new ResponseEntity<Object>(rentalService.monthlyReport(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping(path = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
	private ResponseEntity<Object> createRental(@RequestBody RentalVo rentalVo) {
		try {
			return new ResponseEntity<Object>(rentalService.createRental(rentalVo), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping(path = "/read")
	private ResponseEntity<Object> readRental(@RequestParam Long idRental) {
		try {
			return new ResponseEntity<Object>(rentalService.readRental(idRental), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping(path = "/readAll")
	private ResponseEntity<Object> readAllRental() {
		try {
			return new ResponseEntity<Object>(rentalService.readAllRental(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

//	@PostMapping(path = "/readAll")
//	private ResponseEntity<Object> readAllRental() {
//
//		return new ResponseEntity<Object>(rentalService.readAllRental(), HttpStatus.OK);
//
//	}

	@PostMapping(path = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
	private ResponseEntity<Object> updateRental(@RequestBody Rental Rental) {

		try {
			return new ResponseEntity<Object>(rentalService.updateRental(Rental), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping(path = "/delete")
	private ResponseEntity<Object> deleteRental(Long idRental) {
		try {

			return new ResponseEntity<Object>(rentalService.deleteRental(idRental), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
