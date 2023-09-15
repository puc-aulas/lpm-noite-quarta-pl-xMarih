package com.alugueltech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alugueltech.entity.Equipment;
import com.alugueltech.repository.EquipmentRepository;
import com.alugueltech.repository.MaterialRepository;
import com.alugueltech.vo.EquipmentVO;

@Service
public class EquipmentService {

	@Autowired
	EquipmentRepository equipmentRepository;

	@Autowired
	MaterialRepository materialRepository;

	public Object createEquipment(EquipmentVO equipmentvo) {

		try {
			Equipment equipment = new Equipment();
			equipment.setAvailable(equipmentvo.isAvailable());
			equipment.setDailyRentalRate(equipmentvo.getDailyRentalRate());
			equipment.setDescription(equipmentvo.getDescription());
			equipment.setEquipmentCode(equipmentvo.getEquipmentCode());
			equipment.setMaterial(materialRepository.findByMaterialId(equipmentvo.getMaterialId()));

			return equipmentRepository.save(equipment);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Equipment readEquipment(Long idEquipment) {

		try {
			Equipment equipment = equipmentRepository.findByEquipmentId(idEquipment);

			return equipment;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public Object updateEquipment(Equipment equipment) {
		try {

			return equipmentRepository.save(equipment);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Object deleteEquipment(Long idEquipment) {
		try {
			Equipment equipment = equipmentRepository.findByEquipmentId(idEquipment);
			equipmentRepository.delete(equipment);
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<Equipment> readAllEquipment() {

		List<Equipment> equipmentList = equipmentRepository.findAll();

		return equipmentList;
	}

}
