package com.projectfirst.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.projectfirst.model.UserModel;
import com.projectfirst.repository.UserRepository;
import com.projectfirst.repository.entity.UserEntity;
import com.projectfirst.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepository userRepository;
	@Override
	public List<UserModel> findAll() {
		List<UserModel> result = new ArrayList<>();
		List<UserEntity> user = userRepository.findAll();
		for(UserEntity item : user) {
			UserModel userModel = new UserModel();
			userModel.setUsername(item.getUsername());
			userModel.setPassword(item.getPassword());
			userModel.setContact(item.getPhone() + " , " + item.getEmail());
			userModel.setCreatedby(item.getCreatedby());
			userModel.setCreateddate(item.getCreateddate());
			userModel.setModifiedby(item.getModifiedby());
			userModel.setModifieddate(item.getModifieddate());
			result.add(userModel);
		}
		return result;
	}
	
}
