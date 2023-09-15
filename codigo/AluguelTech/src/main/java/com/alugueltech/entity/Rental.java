package com.alugueltech.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@SuppressWarnings("serial")
@Entity
@Table(name = "rental", schema = "public")
@SequenceGenerator(name = "seq_rental_id", sequenceName = "seq_rental_id", allocationSize = 1)

public class Rental implements Serializable{
	
	@Id
	@Column(name = "rental_id")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_rental_id")
	private Long rentalId;
	
	@ManyToOne( fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "client_id")
	private Cliente cliente;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "equipment_id")
	private Equipment equipment;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "do_date")
	private Date doDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "start_date")
	private Date startDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "end_Date")
	private Date endDate;

	public Long getRentalId() {
		return rentalId;
	}

	public void setRentalId(Long rentalId) {
		this.rentalId = rentalId;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Equipment getEquipment() {
		return equipment;
	}

	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
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