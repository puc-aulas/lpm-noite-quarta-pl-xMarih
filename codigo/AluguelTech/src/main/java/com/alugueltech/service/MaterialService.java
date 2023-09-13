package com.alugueltech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alugueltech.entity.Material;
import com.alugueltech.repository.MaterialRepository;

@Service
public class MaterialService {

	@Autowired
	MaterialRepository materialRepository;

	public Object createMaterial(Material material) {

		try {
			materialRepository.save(material);
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Material readMaterial(Long idMaterial) {

		try {
			Material material = materialRepository.findByMaterialId(idMaterial);

			return material;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public Object updateMaterial(Material material) {
		try {

			return materialRepository.save(material);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Object deleteMaterial(Long idMaterial) {
		try {
			Material material = materialRepository.findByMaterialId(idMaterial);
			materialRepository.delete(material);
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<Material> readAllMaterial() {

		List<Material> MaterialList = materialRepository.findAll();

		return MaterialList;
	}

}
