package com.projectbuilding.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.projectbuilding.entity.BuildingEntity;
import com.projectbuilding.entity.RentAreaEntity;
import com.projectbuilding.model.BuildingDTO;

@Component
public class BuildingDTOConverter {
	@Autowired
	private ModelMapper modelMapper;
	
	public BuildingDTO toBuildingDTO(BuildingEntity item) {
		BuildingDTO building = modelMapper.map(item, BuildingDTO.class);
		building.setAddress(item.getStreet() + "/ " + item.getWard() + "/ " + item.getDistrict());
		List<RentAreaEntity> rentAreas = item.getRentAreaEntities();
		List<String> typeCodes = new ArrayList<>();
		if(item.getTypeCode() != null) {
			for(String s : item.getTypeCode().split(",")) {
				typeCodes.add(s);
			}
		}
		building.setTypeCode(typeCodes);
		if(rentAreas != null){
            String rentArea = rentAreas.stream().map(it->it.getValue().toString()).collect(Collectors.joining(", "));
            building.setRentArea(rentArea);
        }
		return building;
	}
}















