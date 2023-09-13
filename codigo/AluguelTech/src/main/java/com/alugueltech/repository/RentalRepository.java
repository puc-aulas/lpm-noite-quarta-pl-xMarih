package com.alugueltech.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.alugueltech.entity.Rental;

public interface RentalRepository extends JpaRepository<Rental, Long>{

	Rental findByRentalId(@Param("rentalId")Long rentalId);

	@Query(value = "FROM Rental r WHERE r.cliente.clienteId = :clienteId ")
	List<Rental> listarAlugueisPorCliente(@Param("clienteId")Long clienteId);
	
	

}	
