package com.projectfirst.repository;

import java.util.List;

import com.projectfirst.repository.entity.BuildingEntity;

public interface BuildingRepository{
	List<BuildingEntity> findAll();
}
