package com.rest.webservices.restwebservices.user;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class PostEntity {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private String description;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private UserEntity userEntity;
	
	

	public PostEntity() {

	}

	public PostEntity(Integer id, String description) {
		super();
		this.id = id;
		this.description = description;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public UserEntity getUserEntity() {
		return userEntity;
	}

	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}

	@Override
	public String toString() {
		return "PostEntity [id=" + id + ", description=" + description + "]";
	} 
	
	

}
