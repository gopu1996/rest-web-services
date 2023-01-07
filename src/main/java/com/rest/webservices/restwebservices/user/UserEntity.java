package com.rest.webservices.restwebservices.user;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

@Entity(name = "user_details")
public class UserEntity {
	
	@Id
	@GeneratedValue
	private Integer iD;
	

	@Size(min = 2, message = "Name Should atleast 2 characters")
	private String name;
	
	@Past(message = "Birth date should be in Past")
	private LocalDate birthdate;
	
	@OneToMany(mappedBy = "userEntity")
	@JsonIgnore
	private List<PostEntity> posts;
	
	
	protected UserEntity() {
		
	}
	
	
	public UserEntity(Integer iD, String name, LocalDate birthdate) {
		super();
		this.iD = iD;
		this.name = name;
		this.birthdate = birthdate;
	}


	public Integer getiD() {
		return iD;
	}


	public void setiD(Integer iD) {
		this.iD = iD;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public LocalDate getBirthdate() {
		return birthdate;
	}


	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}


	public List<PostEntity> getPosts() {
		return posts;
	}


	public void setPosts(List<PostEntity> posts) {
		this.posts = posts;
	}


	@Override
	public String toString() {
		return "UserEntity [iD=" + iD + ", name=" + name + ", birthdate=" + birthdate + "]";
	}
	
	
	

}
