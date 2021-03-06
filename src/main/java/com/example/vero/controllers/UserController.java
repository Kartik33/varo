package com.example.vero.controllers;

import java.util.List;

import javax.validation.Valid;

import com.example.vero.entity.Address;
import com.example.vero.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.vero.service.AddressJunctionService;
import com.example.vero.service.AddressService;
import com.example.vero.service.DeletedUserService;
import com.example.vero.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class UserController {
    private UserService userService;
    private AddressService addressService;
    private AddressJunctionService addressJunctionService;
    private DeletedUserService deletedUserService;
    private ObjectMapper mapper;
    @Autowired
    public UserController(UserService userService, 
                          AddressService addressService, 
                          AddressJunctionService addressJunctionService, 
                          DeletedUserService deletedUserService, 
                          ObjectMapper objectMapper) {
        this.deletedUserService = deletedUserService;
        this.userService = userService;
        this.addressService = addressService;
        this.addressJunctionService = addressJunctionService;
        this.mapper = objectMapper;
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ResponseEntity<List<User>> getUsers() {
        List<User> users = userService.getUsers();
        return new ResponseEntity<List<User>>(users,HttpStatus.OK);
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public ResponseEntity<User> addUser(@Valid @RequestBody User user){
        try {
            User createdUser = userService.insertUser(user);
            return new ResponseEntity<User>(createdUser,HttpStatus.CREATED);
        } catch (Exception e) {
            throw e;
        }
           
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ResponseEntity<User> getUserByEmail(@RequestParam String email) {
        User user = userService.findUserByEmail(email);
        if (user == null) {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "/user", method = RequestMethod.PATCH)
    public ResponseEntity<User> updateUser(@Valid @RequestBody User user) {
        try {
            userService.insertUser(user);
            return new ResponseEntity<User>(user,HttpStatus.OK);
        } catch (Exception e) {
            throw e;
        }
        
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userService.findUserByUserId(id);
        if (user == null) {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<User>(user,HttpStatus.OK);
    }

    @RequestMapping(value = "/user/{id}/address", method = RequestMethod.POST)
    public ResponseEntity<Address> updateUserAddressById(
                        @Valid @RequestBody Address address, 
                        @PathVariable Long id)
    {
        try {
            Address createdAddress = addressService.insertAddress(address);
            addressJunctionService.insertRecord(createdAddress,id);
            return new ResponseEntity<Address>(createdAddress,HttpStatus.CREATED);
         } catch (Exception e) {
             throw e;
         }
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Long> deleteUserById(@PathVariable Long id) throws Exception{
        
        User user = userService.findUserByUserId(id);
        if (user == null) {
            return new ResponseEntity<Long>(-1L,HttpStatus.NOT_FOUND);
        }
        userService.deleteUserByUserId(id);
        deletedUserService.insertUser(user,mapper.writeValueAsString(user.getAddresses()));
        return new ResponseEntity<Long>(1L,HttpStatus.OK);
    }

}
