package com.alugueltech.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "ato", schema = "public")
@SequenceGenerator(name = "seq_id_equipment", sequenceName = "seq_id_equipment", allocationSize = 1)

public class RentalManager {
	
	@Id
	@Column(name = "id_rental_manager")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "id_equipment")
	private Long rentalManager;

	public Long getRentalManager() {
		return rentalManager;
	}

	public void setRentalManager(Long rentalManager) {
		this.rentalManager = rentalManager;
	}
	
//	@OneToMany(mappedBy = "rentalManager", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	private List<Rental> rentalList;


	
	


}
