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
@SequenceGenerator(name = "seq_equipment_id", sequenceName = "seq_equipment_id", allocationSize = 1)

public class Equipment {

	@Id
	@Column(name = "equipment_id")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "equipment_id")
	private Long equipmentId;
	
	@Column(name = "equipment_code")
	private String equipmentCode;

	@Column(name = "description")
	private String description;

	@Column(name = "daily_rental_rate")
	private Long dailyRentalRate;
	
	@Column(name = "equipment_type")
	private String equipmentType;





	public Long getEquipmentId() {
		return equipmentId;
	}

	public void setEquipmentId(Long equipmentId) {
		this.equipmentId = equipmentId;
	}

	public String getEquipmentType() {
		return equipmentType;
	}

	public void setEquipmentType(String equipmentType) {
		this.equipmentType = equipmentType;
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
