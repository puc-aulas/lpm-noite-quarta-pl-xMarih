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
@SequenceGenerator(name = "seq_id_equipment", sequenceName = "seq_id_equipment", allocationSize = 1)

public class Client {
	
	@Id
	@Column(name = "id_client")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "id_equipment")
	private Long clientId;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "contactInfo")
	private String contactInfo;

	public Long getClientId() {
		return clientId;
	}

	public void setClientId(Long clientId) {
		this.clientId = clientId;
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
