package com.projectbuilding.api;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.projectbuilding.builder.BuildingSearchBuilder;
import com.projectbuilding.converter.BuildingSearchBuilderConverter;
import com.projectbuilding.model.BuildingDTO;
import com.projectbuilding.service.BuildingService;


@RestController
public class BuildingAPI{
	@Autowired
	private BuildingService buildingService;
	@Autowired 
	private BuildingSearchBuilderConverter buildingSearchBuilderConverter;
	@GetMapping(value = "/demo/building")
	public List<BuildingDTO> deMoAPI(@RequestParam Map<String, Object> map,
			                           @RequestParam(value = "typeCode", required = false) List<String> list) {
		BuildingSearchBuilder buildingSearchBuilder = buildingSearchBuilderConverter.toBuildingSearchBuilder(map, list);
		List<BuildingDTO> res = buildingService.findAll(buildingSearchBuilder);
		return res;
	}
}
