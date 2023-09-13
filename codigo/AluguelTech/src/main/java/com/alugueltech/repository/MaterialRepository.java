package com.alugueltech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.alugueltech.entity.Material;

public interface MaterialRepository extends JpaRepository<Material, Long>{

	Material findByMaterialId(@Param("materialId")Long materialId);
	
	

}
