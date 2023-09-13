package com.alugueltech.entity;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "ato", schema = "public")
@SequenceGenerator(name = "seq_id_rental", sequenceName = "seq_id_rental", allocationSize = 1)

public class Rental {
	
	@Id
	@Column(name = "id_rental")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "id_rental")
	private Long rentalId;
	
	@ManyToOne( fetch = FetchType.LAZY)
	@JoinColumn(name = "id_client")
	private Cliente cliente;
	
	@OneToMany(mappedBy = "rental", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<RentalEquipment> equipments;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "do_date")
	private Date doDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "start_date")
	private Date startDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "end_Date")
	private Date endDate;


	public long calcularDiferencaEmDias() {
        long diffInMillies = doDate.getTime() - startDate.getTime();
        return TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
    }
	

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


	public List<RentalEquipment> getEquipments() {
		return equipments;
	}

	public void setEquipments(List<RentalEquipment> equipments) {
		this.equipments = equipments;
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
