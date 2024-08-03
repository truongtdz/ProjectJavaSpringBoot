package com.projectfirst.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projectfirst.model.UserModel;
import com.projectfirst.service.UserService;

@RestController
public class BuildingAPI{
	@Autowired
	private UserService userService;
	@GetMapping(value = "/demo/building")
	public List<UserModel> deMoAPI() {
		List<UserModel> result = userService.findAll();
		return result;
	}
}
