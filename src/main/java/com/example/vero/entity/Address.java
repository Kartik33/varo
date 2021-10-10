package com.example.vero.entity;

import java.io.Serializable;
import java.util.ArrayList;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * This is the Entity class to map address table in the database
 */

@Entity
@Table(name = "address",schema = "public")
public class Address implements Serializable{
    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public String getLinea() {
        return linea;
    }

    public void setLinea(String aLine1) {
        this.linea = aLine1;
    }

    public String getLineb() {
        return lineb;
    }

    public void setLineb(String aLine2) {
        this.lineb = aLine2;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long addressId;
	
	@Column(name="linea") 
	private String linea;

    @Column(name="lineb") 
	private String lineb;

    @Column(name="state")
    private String state;

    @Column(name="city")
    private String city;

    // @JoinTable(name = "address_junction", 
    // joinColumns = {
    //     @JoinColumn(name = "address_id", referencedColumnName = "id",
    //     nullable = false, updatable = false)
    // },
    // inverseJoinColumns = {
    //     @JoinColumn(name = "user_id", referencedColumnName = "id",
    //     nullable = false, updatable = false)
    // } )
    @ManyToMany(mappedBy = "addresses", cascade = CascadeType.ALL)
    private List<User> users = new ArrayList<>();

    public Address() {

    }

    public Address(Long addressId, String linea, String lineb, String state, String city) {
        this.addressId = addressId;
        this.linea = linea;
        this.lineb = lineb;
        this.state = state;
        this.city = city;
    }
}
