package com.projectbuilding.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.projectbuilding.converter.BuildingModelConverter;
import com.projectbuilding.model.BuildingModel;
import com.projectbuilding.repository.BuildingRepository;
import com.projectbuilding.repository.DistrictRopository;
import com.projectbuilding.repository.RentAreaRepository;
import com.projectbuilding.repository.entity.BuildingEntity;
import com.projectbuilding.service.BuildingService;

@Component
public class BuildingServiceImpl implements BuildingService{
	@Autowired
	private BuildingRepository buildingRepository;
	@Autowired
	private BuildingModelConverter buildingModelConverter;
	
	@Override
	public List<BuildingModel> findAll(Map<String, Object> map, List<String> list) {
		List<BuildingModel> result = new ArrayList<>();
		for(BuildingEntity item : buildingRepository.findAll(map, list)) {
			BuildingModel it = buildingModelConverter.toBuildingModel(item);
			result.add(it);
		}
		
		return result;
	}
	
}
