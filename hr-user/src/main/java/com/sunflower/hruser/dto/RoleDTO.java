package com.sunflower.hruser.dto;

import java.io.Serializable;

import com.sunflower.hruser.entities.Role;

public class RoleDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private Long id;	
	private String roleName;
	
	public RoleDTO() {
		
	}
	
	public RoleDTO(Role entity) {
		id = entity.getId();
		roleName = entity.getRoleName();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
}
