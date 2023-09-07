package com.alugueltech.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alugueltech.entity.Equipment;
import com.alugueltech.repository.EquipmentRepository;
import com.alugueltech.vo.EquipmentVO;

@Service
public class EquipmentService {

	@Autowired
	EquipmentRepository equipmentRepository;

	public void createEquipment(EquipmentVO equipmentVO) {

		try {
			Equipment equipment = new Equipment();

			equipment.setEquipmentCode(equipmentVO.getEquipmentCode());
			equipment.setDailyRentalRate(equipmentVO.getDailyRentalRate());
			equipment.setDescription(equipmentVO.getDescription());

			equipmentRepository.save(equipment);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public EquipmentVO readEquipment(Long idEquipment) {

		try {
			Equipment equipment = equipmentRepository.findByEquipmentId(idEquipment);

			EquipmentVO equipmentVO = new EquipmentVO();

			equipmentVO.setDailyRentalRate(equipment.getDailyRentalRate());
			equipmentVO.setDescription(equipment.getDescription());
			equipmentVO.setEquipmentCode(equipment.getEquipmentCode());
			return equipmentVO;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public void updateEquipment(Long idEquipment, EquipmentVO equipmentVO) {
		Equipment equipment = equipmentRepository.findByEquipmentId(idEquipment);
		
		equipment.setEquipmentCode(equipmentVO.getEquipmentCode());
		equipment.setDailyRentalRate(equipmentVO.getDailyRentalRate());
		equipment.setDescription(equipmentVO.getDescription());

		equipmentRepository.save(equipment);
	}

	public void deleteEquipment(Long idEquipment) {
		Equipment equipment = equipmentRepository.findByEquipmentId(idEquipment);
		equipmentRepository.delete(equipment);

	}

	public List<EquipmentVO> readAllEquipment() {
		
		List<Equipment> equipmentList = equipmentRepository.findAll();
		List<EquipmentVO> equipmentVOList = new ArrayList<>();
		
		for (Equipment equipment : equipmentList) {
			EquipmentVO equipmentVO = new EquipmentVO();
			
			equipmentVO.setDailyRentalRate(equipment.getDailyRentalRate());
			equipmentVO.setDescription(equipment.getDescription());
			equipmentVO.setEquipmentCode(equipment.getEquipmentCode());
			
			equipmentVOList.add(equipmentVO);
		}
		
		return equipmentVOList ;
	}

}
