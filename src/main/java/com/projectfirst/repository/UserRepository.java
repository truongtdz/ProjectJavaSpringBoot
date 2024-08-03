package com.projectfirst.repository;

import java.util.List;
import com.projectfirst.repository.entity.UserEntity;

public interface UserRepository {
	List<UserEntity> findAll();
}
