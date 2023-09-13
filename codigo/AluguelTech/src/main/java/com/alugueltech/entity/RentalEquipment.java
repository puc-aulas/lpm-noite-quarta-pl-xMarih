package com.alugueltech.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "rental_equipment", schema = "public")
@SequenceGenerator(name = "seq_id_equipment", sequenceName = "seq_id_equipment", allocationSize = 1)

public class RentalEquipment {
	
	@Id
	@Column(name = "rental_equipment_id")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "id_equipment")
	private Long rentalEquipmentId;

	@ManyToOne( fetch = FetchType.LAZY)
	@JoinColumn(name = "equipment_id")
	private Equipment equipment;
	
	@ManyToOne( fetch = FetchType.LAZY)
	@JoinColumn(name = "rental_id")
	private Rental rental;



	public Long getRentalEquipmentId() {
		return rentalEquipmentId;
	}

	public void setRentalEquipmentId(Long rentalEquipmentId) {
		this.rentalEquipmentId = rentalEquipmentId;
	}

	public Equipment getEquipment() {
		return equipment;
	}

	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}

	public Rental getRental() {
		return rental;
	}

	public void setRental(Rental rental) {
		this.rental = rental;
	}
	



	
	


}
