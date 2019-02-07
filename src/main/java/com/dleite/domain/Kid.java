	package com.dleite.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Kid implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private Integer age;
	private Double allowanceValue;
	
	@JsonIgnore
	@OneToMany(mappedBy="kid")
	private List<RequestPay> requestPays = new ArrayList<>();
	
	@JsonIgnore
	@ManyToOne
    @JoinColumn(name = "userMaster_id")
	private UserMaster userMaster;

	public Kid() {
	}

	public Kid(Integer id, String name, Integer age, Double allowanceValue) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.allowanceValue = allowanceValue;
		
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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Double getAllowanceValue() {
		return allowanceValue;
	}

	public void setAllowanceValue(Double allowanceValue) {
		this.allowanceValue = allowanceValue;
	}

	public UserMaster getUserMaster() {
		return userMaster;
	}

	public void setUserMaster(UserMaster userMaster) {
		this.userMaster = userMaster;
	}
	
	public List<RequestPay> getRequestPays() {
		return requestPays;
	}

	public void setRequestPays(List<RequestPay> requestPays) {
		this.requestPays = requestPays;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Kid other = (Kid) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}



}
