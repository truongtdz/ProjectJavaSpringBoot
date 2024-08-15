package com.projectbuilding.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.projectbuilding.builder.BuildingSearchBuilder;
import com.projectbuilding.converter.BuildingDTOConverter;
import com.projectbuilding.entity.BuildingEntity;
import com.projectbuilding.model.BuildingDTO;
import com.projectbuilding.repository.BuildingRepository;
import com.projectbuilding.service.BuildingService;

@Component
public class BuildingServiceImpl implements BuildingService{
	@Autowired
	private BuildingRepository buildingRepository;
	@Autowired
	private BuildingDTOConverter buildingModelConverter;
	
	@Override
	public List<BuildingDTO> findAll(BuildingSearchBuilder buildingSearchBuilder) {
		List<BuildingDTO> result = new ArrayList<>();
		for(BuildingEntity item : buildingRepository.findAll(buildingSearchBuilder)) {
			BuildingDTO it = buildingModelConverter.toBuildingDTO(item);
			result.add(it);
		}
		
		return result;
	}
	
}
