package com.projectbuilding.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table (name = "role")
public class RoleEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "code", nullable = false)
	private String code;
	
	@ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
	private List<UserEntity> users = new ArrayList<>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<UserEntity> getUsers() {
		return users;
	}

	public void setUsers(List<UserEntity> users) {
		this.users = users;
	}
	
	
		
}
