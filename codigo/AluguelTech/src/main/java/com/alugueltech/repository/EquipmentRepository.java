package com.alugueltech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.alugueltech.entity.Equipment;

public interface EquipmentRepository extends JpaRepository<Equipment, Long> {

	Equipment findByEquipmentId(@Param("id") Long id);

}
