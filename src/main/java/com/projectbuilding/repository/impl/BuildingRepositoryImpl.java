package com.projectbuilding.repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.projectbuilding.util.CheckNumber;
import com.projectbuilding.util.CheckString;
import com.projectbuilding.util.ConnectionDataBase;
import com.projectbuilding.repository.BuildingRepository;
import com.projectbuilding.repository.entity.BuildingEntity;

@Repository
public class BuildingRepositoryImpl implements BuildingRepository{
<<<<<<< HEAD
=======
	@Autowired
	private ModelMapper modelMapper;
>>>>>>> AddAndTest
	
	public static void Jion(Map<String, Object> map, List<String> list, StringBuilder sql){
		Long staffId = (Long) map.get("staffId");
		if(staffId != null) {
			sql.append("\n INNER JOIN assignmentbuilding ON b.id = assignmentbuilding.buildingid");
		}
		if(list != null && list.size() != 0) {
			sql.append("\n INNER JOIN buildingrenttype ON b.id = buildingrenttype.buildingid");
			sql.append("\n INNER JOIN renttype ON renttype.id = buildingrenttype.renttypeid");
		}
		if(CheckNumber.CheckNumber((String)map.get("areaTo")) || CheckNumber.CheckNumber((String)map.get("areaFrom"))) {
			sql.append("\n INNER JOIN rentarea ON rentarea.id = b.id");
		}
	}
	
	public static void WhereBasic(Map<String, Object> map, List<String> list, StringBuilder where) {
		for(Map.Entry<String, Object> entry : map.entrySet()) {
			if(!entry.getKey().equals("staffId") && !entry.getKey().equals("typeCode") &&
					!entry.getKey().startsWith("area") && !entry.getKey().startsWith("rentPrice")) {
				if(CheckNumber.CheckNumber(entry.getKey())) {
					where.append(" AND b." + entry.getKey() + " = " + entry.getValue().toString());
				} else where.append(" AND b." + entry.getKey() + " like '%" + entry.getValue().toString() + "%'");
			}
		}
	}
	
    public static void WhereSpecical(Map<String, Object> map, List<String> list, StringBuilder where) {
		if(CheckString.CheckString((String) map.get("staffId"))) {
			where.append(" AND assignmentbuilding.staffId = " + (Long)map.get("staffId"));
		}
		if(CheckNumber.CheckNumber((String)map.get("areaTo")) || CheckNumber.CheckNumber((String)map.get("areaFrom"))) {
			if(CheckNumber.CheckNumber((String)map.get("areaTo"))) {
				where.append(" AND rentarea.value <= " + (Long)map.get("areaTo"));
			}
			if(CheckNumber.CheckNumber((String)map.get("areaFrom"))) {
				where.append(" AND rentarea.value >= " + (Long)map.get("areaFrom"));
			}
		}
		if(CheckNumber.CheckNumber((String)map.get("rentPriceTo")) || CheckNumber.CheckNumber((String)map.get("rentPriceFrom"))) {
			if(CheckNumber.CheckNumber((String)map.get("rentPriceTo"))) {
				where.append(" AND b.rentPrice <= " + (Long)map.get("rentPriceTo"));
			}
			if(CheckNumber.CheckNumber((String)map.get("rentPriceFrom"))) {
				where.append(" AND b.rentPrice >= " + (Long)map.get("rentPriceFrom"));
			}
		}
		if(CheckString.CheckString("typeCode")) {
			where.append(" AND renttype.code IN('" + String.join("','", list) + "')");
		}
		
	}
	@Override
	public List<BuildingEntity> findAll(Map<String, Object> map, List<String> list) {
		List<BuildingEntity> result = new ArrayList<>();
		String s = "SELECT b.id, b.name, b.street, b.ward, b.districtid, b.numberofbasement, b.managername,"
				+ " b.managerphonenumber, b.floorarea, b.servicefee, b.rentprice FROM building b";
		StringBuilder sql = new StringBuilder(s);
		Jion(map, list, sql); sql.append("\n");
		StringBuilder where = new StringBuilder(" WHERE 1 = 1");
		WhereBasic(map, list, where);
		WhereSpecical(map, list, where);
		sql.append(where);
		try(Connection con = ConnectionDataBase.getConnection();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql.toString());){
			while (rs.next()){
				BuildingEntity item = new BuildingEntity();
						//modelMapper.map(rs, BuildingEntity.class);
				item.setId(Long.parseLong(rs.getString("id")));
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
