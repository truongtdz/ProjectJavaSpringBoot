package com.projectfirst.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectfirst.model.BuildingModel;
import com.projectfirst.repository.BuildingRepository;
import com.projectfirst.repository.entity.BuildingEntity;
import com.projectfirst.service.BuildingService;

@Service
public class BuildingServiceImpl implements BuildingService{
	@Autowired
	private BuildingRepository buildingRepository;
	@Override
	public List<BuildingModel> findAll(Map<String, Object> map) {
		List<BuildingModel> result = new ArrayList<>();
		for(BuildingEntity item : buildingRepository.findAll(map)) {
			BuildingModel rs = new BuildingModel();
			rs.setName(item.getName());
			rs.setAddress(item.getStreet() + "/ " + item.getWard() + "/ " + item.getDistrictid());
			rs.setNumberOfbasement(item.getNumberOfBasement());
			rs.setManagerName(item.getManagerName());
			rs.setManagerPhone(item.getManagerPhoneNumber());
			rs.setFloorArea(item.getFloorArea());
			rs.setRentPrice(item.getRentPrice());
			rs.setServiceFee(item.getServiceFee());
			result.add(rs);
		}
		return result;
	}
	
}
