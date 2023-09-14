package com.alugueltech.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alugueltech.entity.RentalEquipment;

public interface RentalEquipmentRepository extends JpaRepository<RentalEquipment, Long>{

	
//	@Query(value = "FROM RentalEquipment")
//	public List<RentalEquipment> listaAluguelEquipamento(@Param("rentalId")Long rentalId);


	

}	
