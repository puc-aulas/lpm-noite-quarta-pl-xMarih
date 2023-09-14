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

import org.hibernate.annotations.Cascade;
import org.springframework.boot.autoconfigure.integration.IntegrationProperties.RSocket.Client;

@SuppressWarnings("serial")
@Entity
@Table(name = "equipment", schema = "public")
@SequenceGenerator(name = "seq_equipment_id", sequenceName = "seq_equipment_id", allocationSize = 1)

public class Equipment implements Serializable {

	@Id
	@Column(name = "equipment_id")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_equipment_id")
	private Long equipmentId;
	
	@ManyToOne( fetch = FetchType.EAGER, cascade = CascadeType.ALL )
	@JoinColumn(name = "material_id")
	private Material material;
	
	@Column(name = "equipment_code")
	private String equipmentCode;

	@Column(name = "description")
	private String description;

	@Column(name = "daily_rental_rate")
	private Long dailyRentalRate;
	
	@Column(name = "available")
	private boolean available;


	public Long getEquipmentId() {
		return equipmentId;
	}

	public void setEquipmentId(Long equipmentId) {
		this.equipmentId = equipmentId;
	}

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
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

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}





}
