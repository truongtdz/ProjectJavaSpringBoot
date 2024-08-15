package com.projectbuilding.repository;

import java.util.List;

import com.projectbuilding.entity.RentAreaEntity;

public interface RentAreaRepository {
	List<RentAreaEntity> findAreaById(long id);
}
