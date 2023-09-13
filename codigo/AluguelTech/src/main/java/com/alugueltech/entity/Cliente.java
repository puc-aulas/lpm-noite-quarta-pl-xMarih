package com.alugueltech.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "client", schema = "public")
@SequenceGenerator(name = "seq_client_id", sequenceName = "seq_client_id", allocationSize = 1)

public class Cliente {
	
	@Id
	@Column(name = "client_id")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_client_id")
	private Long clienteId;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "contact_info")
	private String contactInfo;



	public Long getClienteId() {
		return clienteId;
	}

	public void setClienteId(Long clienteId) {
		this.clienteId = clienteId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContactInfo() {
		return contactInfo;
	}

	public void setContactInfo(String contactInfo) {
		this.contactInfo = contactInfo;
	}



}
