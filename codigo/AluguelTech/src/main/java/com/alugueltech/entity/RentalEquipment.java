package com.alugueltech.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@SuppressWarnings("serial")
@Entity
@Table(name = "rental_equipment", schema = "public")
@SequenceGenerator(name = "seq_equipment_id", sequenceName = "seq_equipment_id", allocationSize = 1)

public class RentalEquipment implements Serializable{
	
	@Id
	@Column(name = "rental_equipment_id")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_equipment_id")
	private Long rentalEquipmentId;

	@ManyToOne( fetch = FetchType.EAGER)
	@JoinColumn(name = "equipment_id")
	private Equipment equipment;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
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
