package com.projectbuilding.service;

import java.util.List;
import java.util.Map;

import com.projectbuilding.model.BuildingModel;

public interface BuildingService{
	List<BuildingModel> findAll(Map<String, Object> map, List<String> list);
}
