package com.projectfirst.repository;

import java.util.List;
import java.util.Map;

import com.projectfirst.repository.entity.BuildingEntity;

public interface BuildingRepository{
	List<BuildingEntity> findAll(Map<String, Object> map, List<String> list);
}
