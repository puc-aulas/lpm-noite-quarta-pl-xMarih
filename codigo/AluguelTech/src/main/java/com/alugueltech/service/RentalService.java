package com.alugueltech.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import com.alugueltech.entity.Cliente;
import com.alugueltech.entity.Equipment;
import com.alugueltech.entity.Rental;
import com.alugueltech.repository.ClienteRepository;
import com.alugueltech.repository.EquipmentRepository;
import com.alugueltech.repository.RentalRepository;
import com.alugueltech.vo.RentalVo;

@Service
public class RentalService {

	@Autowired
	RentalRepository rentalRepository;

	@Autowired
	ClienteRepository clienteRepository;

	@Autowired
	EquipmentRepository equipmentRepository;

	@PersistenceContext
	private EntityManager entityManager;

	//incluindo o faturamento total.
	public Long totalRevenueByMonth(int month) {

		Long totalRevenue = 0L;
		List<Rental> rentalsByMonth = new ArrayList<Rental>();
		rentalsByMonth = findRentalsByMonth(month);

		for (Rental rental : rentalsByMonth) {
			totalRevenue = (daysDiference(rental) * rental.getEquipment().getDailyRentalRate());
		}
		return totalRevenue;
	}

	public long daysDiference(Rental rental) {
		long diffInMillies = rental.getDoDate().getTime() - rental.getStartDate().getTime();
		return TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
	}

	//Fornecer um relatório mensal que liste todos os aluguéis do mês, 
	public Object monthlyReport(int month) {

		return findRentalsByMonth(month);
	}

	public List<Rental> findRentalsByMonth(int month) {
		String consulta = "SELECT r FROM Rental r " + "WHERE FUNCTION('MONTH', r.startDate) = :month";

		TypedQuery<Rental> query = entityManager.createQuery(consulta, Rental.class);
		query.setParameter("month", month);
		return query.getResultList();
	}

	//Permitir a consulta rápida dos aluguéis atuais e passados de um cliente específico.
	public List<Rental> findRentalByClient(Long clientId) {

		Cliente cliente = clienteRepository.findByClienteId(clientId);

		return rentalRepository.cliente(cliente);
	}

	// Calcular e mostrar o valor total do aluguel para cada registro.

	public Long rentalCalculatorlById(Long rentalId) {

		Rental rental = rentalRepository.findByRentalId(rentalId);

		long diffInMillies = rental.getDoDate().getTime() - rental.getStartDate().getTime();
		Long diferencaEmDias = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
		Long valorTotal = diferencaEmDias * rental.getEquipment().getDailyRentalRate();

		return valorTotal;
	}

	// Registrar novos aluguéis, incluindo todas as informações necessárias
	public Object createRental(RentalVo rentalvo) {

		try {
			Rental rental = new Rental();
			rental.setCliente(clienteRepository.findByClienteId(rentalvo.getIdCliente()));
			rental.setEquipment(equipmentRepository.findByEquipmentId(rentalvo.getIdEquipment()));
			rental.setDoDate(rentalvo.getDoDate());
			rental.setStartDate(rentalvo.getStartDate());

			return rentalRepository.save(rental);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
//Manter um registro dos aluguéis passados, incluindo informações sobre o cliente, o equipamento e as
//	datas de início e término.
	public Rental readRental(Long idRental) {

		try {
			return rentalRepository.findByRentalId(idRental);
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

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

}
