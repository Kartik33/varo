package com.example.vero.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "deleted_users", schema = "public")
public class DeletedUsers implements Serializable{
    
    @Id
	@Column(name="id")
	private Long userId;
	
	@Column(name="f_name") 
	private String fName;
	
	@Column(name="l_name")
	private String lName;
	
	@Column(name="email")
	private String email;

    @Column(name="address")
    private String address;
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public DeletedUsers() {
		
	} 
	
	public DeletedUsers(Long userId, String fName, String lName, String email, Address address) {
		this.userId = userId;
		this.fName =fName;
		this.lName = lName;
		this.email = email;		
	}

    

}
