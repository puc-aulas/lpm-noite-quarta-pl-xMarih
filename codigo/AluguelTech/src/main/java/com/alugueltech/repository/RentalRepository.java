package com.alugueltech.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.alugueltech.entity.Rental;

public interface RentalRepository extends JpaRepository<Rental, Long>{

	@Query("FROM Rental r where r.rentalId = :rentalId")
	Rental findByRentalId(@Param("rentalId")Long rentalId);
	
	
	


	

}	
