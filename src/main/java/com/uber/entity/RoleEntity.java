package com.uber.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Role")
public class RoleEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	
	@ManyToMany(mappedBy = "roles")
	private List<UberEntity> users = new ArrayList<UberEntity>();
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

	public List<UberEntity> getUsers() {
		return users;
	}

	public void setUsers(List<UberEntity> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "RoleEntity [id=" + id + ", name=" + name + "]";
	}
	
	
	
}
