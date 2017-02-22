package com.niit.shopinngcart1.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Proxy;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;
@Table
@Component
@Entity
@Proxy(lazy=false)
public class UserSignUP 
{  
	
	@NotNull
	@Column
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int registrationid;
	@NotNull
	@Id
	private String username;
	
	@NotNull
	private String name;
	@NotNull
	@Email(message="plz enter valid mailid")
	private String email;
	 @NotEmpty(message = "Please enter your password.")
	 @Size(min = 6, max = 15)
	private String password;
	@NotNull
	private Date dob;
	@NotNull
	@Size(min=10,max=12)
	private String mobilenumber;
	@NotNull
	private String role="ROLE_USER";
	@NotNull
	private boolean status=true;
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public int getRegistrationid() {
		return registrationid;
	}
	public void setRegistrationid(int registrationid) {
		this.registrationid = registrationid;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getMobilenumber() {
		return mobilenumber;
	}
	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
