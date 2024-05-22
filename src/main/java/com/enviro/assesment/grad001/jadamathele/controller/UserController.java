package com.enviro.assesment.grad001.jadamathele.controller;

import com.enviro.assesment.grad001.jadamathele.domain.Address;
import com.enviro.assesment.grad001.jadamathele.domain.Company;
import com.enviro.assesment.grad001.jadamathele.domain.Geo;
import com.enviro.assesment.grad001.jadamathele.domain.User;
import com.enviro.assesment.grad001.jadamathele.service.UserService;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public Iterable<User> getUsers() {
        return userService.listUsers();
    }
    
    @GetMapping(path = "/{id}")
    public Optional<User> getUserById(@PathVariable long id) {
    	return userService.listUser(id);
    }
    
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User userDetails) {
    	//details are added
    	User returnValue = userService.createUser(userDetails);
    	//the object is then saved
    	userService.save(returnValue);
    	return new ResponseEntity(returnValue, HttpStatus.CREATED);
    }
    
    @PutMapping(path = "/{id}")
    public ResponseEntity<User> updateUser(@PathVariable long id, @RequestBody User userDetails) {
    	//object is updated then returned as a response 
    	User updatedValue = userService.updateUser(id, userDetails);
    	userService.save(updatedValue);
    	return ResponseEntity.ok(updatedValue);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable long id) {
    	userService.deleteUser(id);
    	return ResponseEntity.ok("User has been successully deleted.");
    }
    
    @DeleteMapping
    public ResponseEntity<String> deleteAllUsers() {
    	userService.deleteUsers();
    	return ResponseEntity.ok("All users have been successully deleted. The database has no data.");
    }
}
