package com.projectbuilding.repository.custom.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.projectbuilding.entity.RentAreaEntity;
import com.projectbuilding.repository.RentAreaRepository;
import com.projectbuilding.util.ConnectionDataBase;

@Repository
public class RentAreaRepositoryImpl implements RentAreaRepository{
	@Override
	public List<RentAreaEntity> findAreaById(long id) {
		List<RentAreaEntity> list = new ArrayList<>();
		String sql = "SELECT value FROM rentarea  WHERE rentarea.buildingid = " + id;
		try(Connection con = ConnectionDataBase.getConnection();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql)){
			while(rs.next()) {
				RentAreaEntity rentAreaEntity = new RentAreaEntity();
				rentAreaEntity.setValue(rs.getLong("value"));
				list.add(rentAreaEntity);
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return list;
	}

}
