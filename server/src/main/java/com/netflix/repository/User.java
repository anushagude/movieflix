package com.netflix.repository;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table
public class User {

	@Id
	@Column(name = "userId")
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
	private String id;

	private String passWord;
	
	@Column(unique = true)
	private String email;
	
	private String firstName;
	
	private String lastName;
	
	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	



	public String getPassWord() {
		return passWord;
	}



	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	@Override
	public String toString() {
		return "User [id=" + id + ", passWord=" + passWord + ", email=" + email + "]";
	}



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	
}
