package com.projectfirst.service;

import java.util.List;
import java.util.Map;

import com.projectfirst.model.BuildingModel;

public interface BuildingService{
	List<BuildingModel> findAll(Map<String, Object> map);
}
