package com.alugueltech.vo;

import java.util.Date;
import java.util.List;

public class RentalVo {
	private Long idCliente;
	private Long idEquipment;
	private Date doDate;
	private Date startDate;

	
	
	public Long getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}
	public Long getIdEquipment() {
		return idEquipment;
	}
	public void setIdEquipment(Long idEquipment) {
		this.idEquipment = idEquipment;
	}
	public Date getDoDate() {
		return doDate;
	}
	public void setDoDate(Date doDate) {
		this.doDate = doDate;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	

	
}
