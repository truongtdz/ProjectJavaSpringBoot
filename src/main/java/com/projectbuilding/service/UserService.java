package com.projectbuilding.service;

import java.util.List;

import com.projectbuilding.model.UserDTO;

public interface UserService {
	List<UserDTO> findAll();
}
