package com.alugueltech.vo;

import java.util.Date;
import java.util.List;

public class RentalVo {
	private Long idCliente;
	private List<Long> idEquipments;
	private Date doDate;
	private Date startDate;
	private Date endDate;
	
	public Long getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}
	public List<Long> getIdEquipments() {
		return idEquipments;
	}
	public void setIdEquipments(List<Long> idEquipments) {
		this.idEquipments = idEquipments;
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
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	
}
