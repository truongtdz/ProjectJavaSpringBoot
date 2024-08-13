package com.projectbuilding.service;

import java.util.List;
import java.util.Map;

import com.projectbuilding.builder.BuildingSearchBuilder;
import com.projectbuilding.model.BuildingDTO;

public interface BuildingService{
	List<BuildingDTO> findAll(BuildingSearchBuilder buildingSearchBuilder);
}
