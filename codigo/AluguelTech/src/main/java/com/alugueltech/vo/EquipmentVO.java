package com.alugueltech.vo;

public class EquipmentVO {
	

	private Long materialId;
	private String equipmentCode;
	private String description;
	private Long dailyRentalRate;
	private boolean available;
	
	
	public Long getMaterialId() {
		return materialId;
	}
	public void setMaterialId(Long materialId) {
		this.materialId = materialId;
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
