package com.projectbuilding.repository;

import java.util.List;

import com.projectbuilding.builder.BuildingSearchBuilder;
import com.projectbuilding.entity.BuildingEntity;

public interface BuildingRepository{
	List<BuildingEntity> findAll(BuildingSearchBuilder buildingSearchBuilder);
}
