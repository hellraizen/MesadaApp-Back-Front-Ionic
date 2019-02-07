package com.dleite.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.dleite.domain.UserMaster;

public class UserMasterDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@NotEmpty
	@Length(min=5 , max=80, message="O tamanho deve ser entre 5 a 80 caracteres")
	private String name;

	public UserMasterDTO() {
		
	}
	
	public UserMasterDTO(UserMaster userMaster) {
		id = userMaster.getId();
		name = userMaster.getName();
		
	}

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
	
	
}
