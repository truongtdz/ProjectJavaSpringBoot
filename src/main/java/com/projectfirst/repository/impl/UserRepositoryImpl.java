package com.projectfirst.repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.projectfirst.repository.UserRepository;
import com.projectfirst.repository.entity.UserEntity;


@Repository
public class UserRepositoryImpl implements UserRepository{
	private final String URL = "jdbc:mysql://localhost:3306/estateadvance";
	private final String Name = "root";
	private final String Pass = "123456";
	
	@Override
	public List<UserEntity> findAll() {
		List<UserEntity> result = new ArrayList<>();
		String sql = "SELECT * FROM User";
		try (Connection con = DriverManager.getConnection(URL, Name, Pass);
	             Statement stmt = con.createStatement();
	             ResultSet rs = stmt.executeQuery(sql)){
			while(rs.next()) {
				UserEntity user = new UserEntity();
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setFullname(rs.getString("fullname"));
				user.setEmail(rs.getString("email"));
				user.setPhone(rs.getString("phone"));
				user.setStatus(Integer.parseInt(rs.getString("status")));
				user.setCreateddate(rs.getString("createddate"));
				user.setModifieddate(rs.getString("modifieddate"));
				user.setCreatedby(rs.getString("createdby"));
				user.setModifiedby(rs.getString("modifiedby"));
				result.add(user);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

}
