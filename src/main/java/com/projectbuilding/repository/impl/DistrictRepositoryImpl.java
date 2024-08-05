package com.projectbuilding.repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.springframework.stereotype.Repository;

import com.projectbuilding.repository.DistrictRopository;
import com.projectbuilding.repository.entity.DistrictEntity;

@Repository
public class DistrictRepositoryImpl implements DistrictRopository{
	private final String URL = "jdbc:mysql://localhost:3306/estatebasic";
	private final String UserName = "root";
	private final String Password = "123456";
	
	@Override
	public DistrictEntity findNameById(Long id) {
		String sql = "SELECT d.name FROM district d WHERE d.id = " + id;
		DistrictEntity districtEntity = new DistrictEntity();
		try(Connection con = DriverManager.getConnection(URL, UserName, Password);
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql)){
			while(rs.next()) {
				districtEntity.setName(rs.getString("name"));
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return districtEntity;
	}
	
}
