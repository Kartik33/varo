package com.example.vero.service;

import com.example.vero.entity.AddressJunction;
import com.example.vero.entity.Address;
public interface AddressJunctionService {
    
    public AddressJunction insertRecord(Address address, Long id);
}
