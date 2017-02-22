package com.niit.shopinngcart1.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Proxy;
import org.springframework.stereotype.Component;

@Table
@Entity
@Component
@Proxy(lazy=false)
public class Supplier {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) 
	private int supid;
	@Size(min=5)
	private String supname;
	private String supaddress;
	private String supemail;
	private String supcontact;

	
	public long getSupid() {
		return supid;
	}
	
	public void setSupid(int supid) {
		this.supid = supid;
	}
	public String getSupname() {
		return supname;
	}
	public void setSupname(String supname) {
		this.supname = supname;
	}
	public String getSupaddress() {
		return supaddress;
	}
	public void setSupaddress(String supaddress) {
		this.supaddress = supaddress;
	}
	public String getSupemail() {
		return supemail;
	}
	public void setSupemail(String supemail) {
		this.supemail = supemail;
	}
	public String getSupcontact() {
		return supcontact;
	}
	public void setSupcontact(String supcontact) {
		this.supcontact = supcontact;
	}
	
	

}
