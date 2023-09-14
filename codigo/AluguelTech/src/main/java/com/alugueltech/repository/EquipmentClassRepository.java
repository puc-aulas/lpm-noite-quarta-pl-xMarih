package com.alugueltech.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.Hibernate;

import com.alugueltech.entity.Rental;
import com.alugueltech.entity.RentalEquipment;

public class EquipmentClassRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	public List<Rental> recuperaTodosAlgueis() {
		Query query = getEntityManager().createQuery("FROM Rental");

		List<Rental> listaAlugueis = new ArrayList<Rental>();
		inicializaGrafo(listaAlugueis);
		listaAlugueis = query.getResultList();
		// query.setParameter("dataFato", dataFato);
		return listaAlugueis;

	}

	private void inicializaGrafo(List<Rental> listaAlugueis) {
		for (Rental rental : listaAlugueis) {

			Hibernate.initialize(rental.getCliente());

			for (RentalEquipment rentalEquipment : rental.getEquipments()) {
				Hibernate.initialize(rentalEquipment.getEquipment());
				Hibernate.initialize(rentalEquipment.getEquipment());

			}
		}

	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

}
