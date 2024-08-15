package com.projectbuilding.repository.custom.impl;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Repository;

import com.projectbuilding.builder.BuildingSearchBuilder;
import com.projectbuilding.entity.BuildingEntity;
import com.projectbuilding.repository.BuildingRepository;

@Repository
@Transactional
@Primary
public class BuildingRepositoryImpl implements BuildingRepository{
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<BuildingEntity> findAll(BuildingSearchBuilder buildingSearchBuilder) {
		StringBuilder sql = new StringBuilder(" SELECT b.* FROM building b ");
        Jion(buildingSearchBuilder, sql);
        sql.append(" WHERE 1 = 1 ");
        WhereBasic(buildingSearchBuilder, sql);
        WhereSpecical(buildingSearchBuilder, sql);
        sql.append(" GROUP BY b.id");
        Query query = entityManager.createNativeQuery(sql.toString(), BuildingEntity.class);
        return query.getResultList();
	}

	public static void Jion(BuildingSearchBuilder buildingSearchBuilder, StringBuilder sql){
		Integer staffId = buildingSearchBuilder.getStaffId();
		if(staffId != null) {
			sql.append(" INNER JOIN assignmentbuilding ass ON b.id = ass.buildingid");
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
	                            sql.append(" AND b." + fieldName + " = " + value + " ");
	                        } else {
	                            sql.append(" AND b." + fieldName + " LIKE '%" + value + "%' ");
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
            sql.append(" AND u.id" + " = " + staffId + " ");
        }

        Integer areaTo = buildingSearchBuilder.getAreaTo();
        Integer areaFrom = buildingSearchBuilder.getAreaFrom();
        if(areaFrom != null || areaTo != null){
            sql.append(" AND EXISTS (SELECT * FROM rentarea r WHERE b.id = r.buildingid ");
            if(areaFrom != null){
                sql.append(" AND r.value >= " + areaFrom + " ");
            }
            if(areaTo != null){
                sql.append(" AND r.value <= " + areaTo + " ");
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
            String tmp = typeCode.stream().map(it-> "b.typecode LIKE " + "'%" + it + "%'").collect(Collectors.joining(" OR "));
            sql.append(tmp + " ) ");
        }
		
	}
}
