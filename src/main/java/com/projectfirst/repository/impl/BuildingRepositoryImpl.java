package com.projectfirst.repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.projectfirst.repository.BuildingRepository;
import com.projectfirst.repository.entity.BuildingEntity;

@Repository
public class BuildingRepositoryImpl implements BuildingRepository{
	private final String URL = "jdbc:mysql://localhost:3306/estatebasic";
	private final String UserName = "root";
	private final String Password = "123456";
	@Override
	public List<BuildingEntity> findAll(Map<String, Object> map) {
		List<BuildingEntity> result = new ArrayList<>();
		String s = "SELECT name, street, ward, districtid, numberofbasement, managername,"
				+ " managerphonenumber, floorarea, servicefee, rentprice FROM building WHERE 1 = 1";
		StringBuilder sql = new StringBuilder(s);
		for(Map.Entry<String, Object> entry : map.entrySet()) {
			if(entry.getKey().equals("areato")) {
				sql.append(" AND rentprice > " + entry.getValue());
			} else if(entry.getKey().equals("areafrom")) {
				sql.append(" AND rentprice < " + entry.getValue());
			}
			else if(entry.getValue() != null){
				sql.append(" AND " + entry.getKey() + " = '" + entry.getValue() + "'");
			} 
		}
		try(Connection con = DriverManager.getConnection(URL, UserName, Password);
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql.toString());){
			while (rs.next()){
				BuildingEntity item = new BuildingEntity();
				item.setName(rs.getString("name"));
				item.setStreet(rs.getString("street"));
				item.setWard(rs.getString("ward"));
				item.setDistrictid(Integer.parseInt(rs.getString("districtid")));
				item.setNumberOfBasement(Integer.parseInt(rs.getString("numberOfBasement")));
				item.setManagerName(rs.getString("managername"));
				item.setManagerPhoneNumber(rs.getString("managerphonenumber"));
				item.setFloorArea(Integer.parseInt(rs.getString("floorarea")));
				item.setServiceFee(rs.getString("servicefee"));
				item.setRentPrice(Integer.parseInt(rs.getString("rentprice")));
				result.add(item);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
}
