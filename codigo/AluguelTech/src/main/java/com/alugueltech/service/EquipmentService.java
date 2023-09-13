package com.alugueltech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alugueltech.entity.Equipment;
import com.alugueltech.repository.EquipmentRepository;

@Service
public class EquipmentService {

	@Autowired
	EquipmentRepository equipmentRepository;

	public Object createEquipment(Equipment equipment) {

		try {
			equipmentRepository.save(equipment);
			return null;
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
