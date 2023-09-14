package com.alugueltech.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alugueltech.entity.Rental;
import com.alugueltech.entity.RentalEquipment;
import com.alugueltech.repository.ClienteRepository;
import com.alugueltech.repository.EquipmentClassRepository;
import com.alugueltech.repository.EquipmentRepository;
import com.alugueltech.repository.RentalEquipmentRepository;
import com.alugueltech.repository.RentalRepository;
import com.alugueltech.vo.RentalVo;

@Service
public class RentalService {

	@Autowired
	RentalRepository rentalRepository;

	@Autowired
	RentalEquipmentRepository rentalEquipmentRepository;

	@Autowired
	ClienteRepository clienteRepository;

	@Autowired
	EquipmentRepository equipmentRepository;

	EquipmentClassRepository equipmentClassRepository;

	public List<Rental> listRentalByClient(Long clienteId) {
		return rentalRepository.findAll();
	}

	public Object monthlyReport() {
		List<Rental> listRental = new ArrayList<Rental>();
		listRental = rentalRepository.findAll();

		for (Rental rental : listRental) {
			for (RentalEquipment rentalEquipment : rental.getEquipments()) {

			}
		}

		return null;
	}

	public Long rentalCalculatorlById(Long rentalId) {

		Rental rental = rentalRepository.findByRentalId(rentalId);
		// Long diferencaEmDias = calcularDiferencaEmDias(rental);

		long diffInMillies = rental.getDoDate().getTime() - rental.getStartDate().getTime();
		Long diferencaEmDias = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);

		Long valorTotal = (long) 0;

		for (RentalEquipment rentalEquipment : rental.getEquipments()) {
			valorTotal += rentalEquipment.getEquipment().getDailyRentalRate() * diferencaEmDias;
		}

		return valorTotal;
	}

	public long calcularDiferencaEmDias(Rental rental) {
		long diffInMillies = rental.getDoDate().getTime() - rental.getStartDate().getTime();
		return TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
	}

	public Object createRental(RentalVo rentalVo) {

		try {

			Rental rental = new Rental();

			rental.setCliente(clienteRepository.findByClienteId(rentalVo.getIdCliente()));
			rental.setDoDate(rentalVo.getDoDate());
			rental.setEndDate(rentalVo.getEndDate());
			rental.setStartDate(rentalVo.getStartDate());

			List<RentalEquipment> equipmentsList = new ArrayList<RentalEquipment>();
			for (Long idEquipment : rentalVo.getIdEquipments()) {
				RentalEquipment rentalEquipment = new RentalEquipment();

				rentalEquipment.setEquipment(equipmentRepository.findByEquipmentId(idEquipment));
				rentalEquipment.setRental(rental);
				equipmentsList.add(rentalEquipment);
			}
			rental.setEquipments(equipmentsList);
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

		return rentalRepository.findAll();

	}

}
