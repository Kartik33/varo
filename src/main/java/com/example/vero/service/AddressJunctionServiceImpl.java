package com.example.vero.service;

import com.example.vero.entity.Address;
import com.example.vero.entity.AddressJunction;
import com.example.vero.repository.AddressJunctionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressJunctionServiceImpl implements AddressJunctionService{

    @Autowired
    AddressJunctionRepository addressJunctionRepository;


    @Override
    public AddressJunction insertRecord(Address createdAddress, Long id) {
        AddressJunction createdAddressJunction = new AddressJunction();
        createdAddressJunction.setAddressId(createdAddress.getAddressId());
        createdAddressJunction.setUserId(id);
        AddressJunction createdAddressJ = addressJunctionRepository.save(createdAddressJunction);
        return createdAddressJ;
    }
    
}
