package com.alugueltech.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "material", schema = "public")
@SequenceGenerator(name = "seq_material_id", sequenceName = "seq_material_id", allocationSize = 1)

public class Material {
	
	public static final String BETONEIRA = "1";
	
	@Id
	@Column(name = "material_id")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_material_id")
	private Long materialId;
	
	
	@Column(name = "name")
	private String name;


	public Long getMaterialId() {
		return materialId;
	}


	public void setMaterialId(Long materialId) {
		this.materialId = materialId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
	

}