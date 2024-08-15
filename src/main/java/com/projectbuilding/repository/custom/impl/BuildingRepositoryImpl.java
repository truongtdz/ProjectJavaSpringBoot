package com.projectbuilding.repository.custom.impl;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Repository;

import com.projectbuilding.util.CheckNumber;
import com.projectbuilding.util.CheckString;
import com.projectbuilding.util.ConnectionDataBase;
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
	

	@Override
	public List<BuildingEntity> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BuildingEntity> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BuildingEntity> findAllById(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends BuildingEntity> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends BuildingEntity> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends BuildingEntity> List<S> saveAllAndFlush(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAllInBatch(Iterable<BuildingEntity> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public BuildingEntity getOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BuildingEntity getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BuildingEntity getReferenceById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends BuildingEntity> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends BuildingEntity> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<BuildingEntity> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends BuildingEntity> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<BuildingEntity> findById(Long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(BuildingEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends BuildingEntity> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends BuildingEntity> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public <S extends BuildingEntity> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends BuildingEntity> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends BuildingEntity> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <S extends BuildingEntity, R> R findBy(Example<S> example,
			Function<FetchableFluentQuery<S>, R> queryFunction) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
