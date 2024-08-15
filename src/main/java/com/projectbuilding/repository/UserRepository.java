package com.projectbuilding.repository;

import java.util.List;

import com.projectbuilding.entity.UserEntity;

public interface UserRepository {
	List<UserEntity> findAll();
}
