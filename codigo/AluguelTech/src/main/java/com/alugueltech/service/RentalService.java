package com.alugueltech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alugueltech.entity.Rental;
import com.alugueltech.entity.RentalEquipment;
import com.alugueltech.repository.RentalRepository;

@Service
public class RentalService {

	@Autowired
	RentalRepository rentalRepository;

	public List<Rental> listarAlugueisPorCliente(Long clienteId){
		return rentalRepository.listarAlugueisPorCliente(clienteId);
	}
	
	public Long calculaValorAluguelPorEquipment(Long rentalId) {
		
		Rental rental = rentalRepository.findByRentalId(rentalId);
		Long diferencaEmDias = rental.calcularDiferencaEmDias();
		Long valorTotal = (long) 0 ;
		
		for (RentalEquipment rentalEquipment : rental.getEquipments()) {
			valorTotal += rentalEquipment.getEquipment().getDailyRentalRate() * diferencaEmDias;
		}
	
		return valorTotal;
	}
	public Object createRental(Rental rental) {

		try {
			rentalRepository.save(rental);
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Rental readRental(Long idRental) {

		try {
			Rental rental = rentalRepository.findByRentalId(idRental);

			return rental;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public Object updateRental(Rental rental) {
		try {

			return rentalRepository.save(rental);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Object deleteRental(Long idRental) {
		try {
			Rental rental = rentalRepository.findByRentalId(idRental);
			rentalRepository.delete(rental);
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<Rental> readAllRental() {

		List<Rental> RentalList = rentalRepository.findAll();

		return RentalList;
	}

}
