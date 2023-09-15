package com.alugueltech.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.alugueltech.entity.Cliente;
import com.alugueltech.entity.Rental;

@Repository
public interface RentalRepository extends JpaRepository<Rental, Long>{

	@Query("FROM Rental r where r.rentalId = :rentalId")
	Rental findByRentalId(@Param("rentalId")Long rentalId);

//	@Query("FROM Rental r where r.cliente = :client")
//	List<Rental> buscaAlugueisPorClient(@Param("client")Cliente cliente);
//	

	
	
	List<Rental> cliente(Cliente clientId);
	
	List<Rental> doDate(Date doDate);
	
	
	
	


	

}	
