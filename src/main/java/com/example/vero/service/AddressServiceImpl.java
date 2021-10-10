package com.example.vero.service;

import com.example.vero.entity.Address;
import com.example.vero.repository.AddressRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService{
    
    @Autowired
    AddressRepository addressRepository;

    @Override
    public Address insertAddress(Address address) {
        Address createdAddress = addressRepository.save(address);
        return createdAddress;
    }


}
