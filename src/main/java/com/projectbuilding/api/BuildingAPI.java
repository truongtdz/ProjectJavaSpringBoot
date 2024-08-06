package com.projectbuilding.api;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.projectbuilding.model.BuildingModel;
import com.projectbuilding.service.BuildingService;


@RestController
public class BuildingAPI{
	@Autowired
	private BuildingService buildingService;
	@GetMapping(value = "/demo/building")
	public List<BuildingModel> deMoAPI(@RequestParam Map<String, Object> map,
			                           @RequestParam(value = "typeCode", required = false) List<String> list) {
		List<BuildingModel> res = buildingService.findAll(map, list);
		return res;
	}
}
