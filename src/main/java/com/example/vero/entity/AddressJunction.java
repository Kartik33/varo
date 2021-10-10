package com.example.vero.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This is the Entity class to address_junction table
 */

@Entity
@Table(name = "address_junction",schema = "public")
public class AddressJunction implements Serializable{
    public Long getAddressJunctionId() {
        return addressJunctionId;
    }

    public void setAddressJunctionId(Long addressJunctionId) {
        this.addressJunctionId = addressJunctionId;
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public AddressJunction() {

    }

    public AddressJunction(Long id, Long addressId, Long userId)  {
        this.addressJunctionId = id;
        this.userId = userId;
        this.addressId = addressId;
    }

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long addressJunctionId;

    @Column(name = "address_id")
	private Long addressId;

    @Column(name = "user_id")
	private Long userId;
    
}
