package com.example.vero.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
/**
 * Entity class to map users table in the database
 */

@Entity
@Table(name = "users", schema = "public")
public class User implements Serializable{
	
	/**
	 * 
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long userId;
	
	@Column(name="f_name") 
	private String fName;
	
	@Column(name="l_name")
	private String lName;
	
	@Column(name="email")
	private String email;

	@ManyToMany(fetch = FetchType.LAZY, cascade =  CascadeType.ALL)
	@JoinTable(name = "address_junction", 
		joinColumns = {
			@JoinColumn(name = "user_id", referencedColumnName = "id",
			nullable = false, updatable = false)
		},
		inverseJoinColumns = {
			@JoinColumn(name = "address_id", referencedColumnName = "id",
			nullable = false, updatable = false)
		} )

	
	private List<Address> addresses = new ArrayList<>();

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}
	
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public User() {
		
	} 
	
	public User(Long userId, String fName, String lName, String email, Address address) {
		this.userId = userId;
		this.fName =fName;
		this.lName = lName;
		this.email = email;		
	}
	
}

