package com.projectbuilding.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projectbuilding.entity.BuildingEntity;
import com.projectbuilding.repository.custom.BuildingRepositoryCustom;

public interface BuildingRepository extends JpaRepository<BuildingEntity, Long>, BuildingRepositoryCustom{
	
}
