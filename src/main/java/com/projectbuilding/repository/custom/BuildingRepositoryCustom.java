package com.projectbuilding.repository.custom;

import java.util.List;

import com.projectbuilding.builder.BuildingSearchBuilder;
import com.projectbuilding.entity.BuildingEntity;

public interface BuildingRepositoryCustom {
	List<BuildingEntity> findAll(BuildingSearchBuilder buildingSearchBuilder);
}
