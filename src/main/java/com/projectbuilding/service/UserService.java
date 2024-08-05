package com.projectbuilding.service;

import java.util.List;

import com.projectbuilding.model.UserModel;

public interface UserService {
	List<UserModel> findAll();
}
