package com.projectbuilding.repository.impl;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.projectbuilding.util.CheckNumber;
import com.projectbuilding.util.CheckString;
import com.projectbuilding.util.ConnectionDataBase;
import com.projectbuilding.builder.BuildingSearchBuilder;
import com.projectbuilding.repository.BuildingRepository;
import com.projectbuilding.repository.entity.BuildingEntity;

@Repository
public class BuildingRepositoryImpl implements BuildingRepository{
	
	@PersistenceContext
	private EntityManager entityManager;

	public static void Jion(BuildingSearchBuilder buildingSearchBuilder, StringBuilder sql){
		Integer staffId =buildingSearchBuilder.getStaffId();
		if(staffId != null) {
			sql.append("\n INNER JOIN assignmentbuilding ON b.id = assignmentbuilding.buildingid");
		}
		List<String> typeCode = buildingSearchBuilder.getTypeCode();
		if(typeCode != null && typeCode.size() != 0) {
			sql.append("\n INNER JOIN buildingrenttype ON b.id = buildingrenttype.buildingid");
			sql.append("\n INNER JOIN renttype ON renttype.id = buildingrenttype.renttypeid");
		}
	}
	
	public static void WhereBasic(BuildingSearchBuilder buildingSearchBuilder, StringBuilder sql) {
		 try{
	            Field[] fields = BuildingSearchBuilder.class.getDeclaredFields();
	            for(Field item : fields){
	                item.setAccessible(true);
	                String fieldName = item.getName();
	                if(!fieldName.equals("staffId") && !fieldName.equals("typeCode")
	                        && !fieldName.startsWith("rentPrice") && !fieldName.startsWith("area")) {
	                    Object value = item.get(buildingSearchBuilder);
	                    if(value != null && !value.toString().isEmpty()) {
	                        if (item.getType().getName().equals("java.lang.Integer")) {
	                            sql.append("AND b." + fieldName + " = " + value + " ");
	                        } else {
	                            sql.append("AND b." + fieldName + " LIKE '%" + value + "%' ");
	                        }
	                    }
	                }
	            }
	        }
	        catch (Exception e){
	            e.printStackTrace();
	        }
	}
	
    public static void WhereSpecical(BuildingSearchBuilder buildingSearchBuilder, StringBuilder sql) {
    	Integer staffId = buildingSearchBuilder.getStaffId();
        if(staffId != null){
            sql.append("AND u.id" + " = " + staffId + " ");
        }

        Integer areaTo = buildingSearchBuilder.getAreaTo();
        Integer areaFrom = buildingSearchBuilder.getAreaFrom();
        if(areaFrom != null || areaTo != null){
            sql.append(" AND EXISTS (SELECT * FROM rentarea r WHERE b.id = r.buildingid ");
            if(areaFrom != null){
                sql.append("AND r.value >= " + areaFrom + " ");
            }
            if(areaTo != null){
                sql.append("AND r.value <= " + areaTo + " ");
            }
            sql.append(") ");
        }

        Integer rentPriceTo = buildingSearchBuilder.getRentPriceTo();
        Integer rentPriceFrom = buildingSearchBuilder.getRentPriceFrom();
        if(rentPriceFrom != null || rentPriceTo != null){
            if(rentPriceFrom != null){
                sql.append("AND b.rentprice >= " + rentPriceFrom + " ");
            }
            if(rentPriceTo != null){
                sql.append("AND b.rentprice <= " + rentPriceTo + " ");
            }
        }
        List<String> typeCode = buildingSearchBuilder.getTypeCode();
        if(typeCode != null && typeCode.size() > 0){
            sql.append(" AND (");
            String tmp = typeCode.stream().map(it-> "b.type LIKE " + "'%" + it + "%'").collect(Collectors.joining(" OR "));
            sql.append(tmp + " ) ");
        }
		
	}
	@Override
	public List<BuildingEntity> findAll(BuildingSearchBuilder buildingSearchBuilder) {
		StringBuilder sql = new StringBuilder("SELECT b.* FROM building b ");
        Jion(buildingSearchBuilder, sql);
        sql.append("WHERE 1 = 1 ");
        WhereBasic(buildingSearchBuilder, sql);
        WhereSpecical(buildingSearchBuilder, sql);
        sql.append(" GROUP BY b.id");
        Query query = entityManager.createNativeQuery(sql.toString(), BuildingEntity.class);
        return query.getResultList();
	}
	
}
