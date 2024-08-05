package com.projectbuilding.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectbuilding.model.BuildingModel;
import com.projectbuilding.repository.BuildingRepository;
import com.projectbuilding.repository.DistrictRopository;
import com.projectbuilding.repository.entity.BuildingEntity;
import com.projectbuilding.repository.entity.DistrictEntity;
import com.projectbuilding.service.BuildingService;

@Service
public class BuildingServiceImpl implements BuildingService{
	@Autowired
	private BuildingRepository buildingRepository;
	@Autowired
	private DistrictRopository districtRopository;
	@Override
	public List<BuildingModel> findAll(Map<String, Object> map, List<String> list) {
		List<BuildingModel> result = new ArrayList<>();
		for(BuildingEntity item : buildingRepository.findAll(map, list)) {
			BuildingModel rs = new BuildingModel();
			rs.setName(item.getName());
			DistrictEntity districtEntity = districtRopository.findNameById(item.getDistrictid());
			rs.setAddress(item.getStreet() + "/ " + item.getWard() + "/ " + districtEntity.getName());
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
