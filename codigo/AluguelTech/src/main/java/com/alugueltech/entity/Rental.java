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
@Table(name = "ato", schema = "public")
@SequenceGenerator(name = "seq_id_rental", sequenceName = "seq_id_rental", allocationSize = 1)

public class Rental {
	
	@Id
	@Column(name = "id_rental")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "id_rental")
	private Long rental;
//	
//	@OneToMany(mappedBy = "Rental", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	private List<Equipment> equipmentList;
	
	@ManyToOne( fetch = FetchType.LAZY)
	@JoinColumn(name = "id_client")
	private Client client;
	
	@Column(name = "equipment-code")
	private String equipmentCode;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "daily-rental-rate")
	private Long dailyRentalRate;

	public Long getRental() {
		return rental;
	}

	public void setRental(Long rental) {
		this.rental = rental;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public String getEquipmentCode() {
		return equipmentCode;
	}

	public void setEquipmentCode(String equipmentCode) {
		this.equipmentCode = equipmentCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getDailyRentalRate() {
		return dailyRentalRate;
	}

	public void setDailyRentalRate(Long dailyRentalRate) {
		this.dailyRentalRate = dailyRentalRate;
	}
	
	


}
