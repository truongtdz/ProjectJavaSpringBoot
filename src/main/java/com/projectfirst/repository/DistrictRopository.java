package com.projectfirst.repository;

import com.projectfirst.repository.entity.DistrictEntity;

public interface DistrictRopository {
	DistrictEntity findNameById(Long id);
}
