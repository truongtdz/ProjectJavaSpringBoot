package com.projectbuilding.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectbuilding.model.BuildingModel;
import com.projectbuilding.repository.DistrictRopository;
import com.projectbuilding.repository.RentAreaRepository;
import com.projectbuilding.repository.entity.BuildingEntity;
import com.projectbuilding.repository.entity.DistrictEntity;
import com.projectbuilding.repository.entity.RentAreaEntity;

@Service
public class BuildingModelConverter {
	@Autowired
	private DistrictRopository districtRopository;
	@Autowired
	private RentAreaRepository rentAreaRepository;
	@Autowired
	private ModelMapper modelMapper;
	
	public BuildingModel toBuildingModel(BuildingEntity item) {
		BuildingModel rs = modelMapper.map(item, BuildingModel.class);
		rs.setName(item.getName());
		DistrictEntity districtEntity = districtRopository.findNameById(item.getDistrictid());
		rs.setAddress(item.getStreet() + "/ " + item.getWard() + "/ " + districtEntity.getName());
//		rs.setNumberOfbasement(item.getNumberOfBasement());
//		rs.setManagerName(item.getManagerName());
//		rs.setManagerPhone(item.getManagerPhoneNumber());
//		rs.setFloorArea(item.getFloorArea());
//		rs.setRentPrice(item.getRentPrice());
//		rs.setServiceFee(item.getServiceFee());
		List<RentAreaEntity> rentAreas = rentAreaRepository.findAreaById(item.getId());
		String resultRentAreas = rentAreas.stream().map(it -> it.getValue().toString()).collect(Collectors.joining(","));
		rs.setRentArea(resultRentAreas);
		return rs;
	}
}
