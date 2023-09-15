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


	@PostMapping(path = "/total-revenue")
	private ResponseEntity<Object> totalRevenueByMonth(@RequestParam int month) {
		try {
			return new ResponseEntity<Object>(rentalService.totalRevenueByMonth(month), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(path = "/rental-by-client")
	private ResponseEntity<Object> findRentalByClient(@RequestParam Long clientId) {
		try {
			return new ResponseEntity<Object>(rentalService.findRentalByClient(clientId), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(path = "/rental-calculator")
	private ResponseEntity<Object> rentalCalculatorlById(@RequestParam Long rentalId) {
		try {
			return new ResponseEntity<Object>(rentalService.rentalCalculatorlById(rentalId), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping(path = "/monthly-report")
	private ResponseEntity<Object> monthlyReport(@RequestParam int month) {
		try {
			return new ResponseEntity<Object>(rentalService.monthlyReport(month), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
//////////////////////////////////////////////////////////////////////
	@PostMapping(path = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
	private ResponseEntity<Object> createRental(@RequestBody RentalVo rentalvo) {
		try {
			return new ResponseEntity<Object>(rentalService.createRental(rentalvo), HttpStatus.OK);
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
