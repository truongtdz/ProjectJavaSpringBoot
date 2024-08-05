package com.projectbuilding.repository;

import java.util.List;

import com.projectbuilding.repository.entity.UserEntity;

public interface UserRepository {
	List<UserEntity> findAll();
}
