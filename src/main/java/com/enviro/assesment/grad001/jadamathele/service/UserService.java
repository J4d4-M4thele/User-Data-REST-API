package com.enviro.assesment.grad001.jadamathele.service;

import com.enviro.assesment.grad001.jadamathele.domain.Address;
import com.enviro.assesment.grad001.jadamathele.domain.Company;
import com.enviro.assesment.grad001.jadamathele.domain.Geo;
import com.enviro.assesment.grad001.jadamathele.domain.User;
import com.enviro.assesment.grad001.jadamathele.exception.UserNotFoundException;
import com.enviro.assesment.grad001.jadamathele.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    public User createUser(User user) {
    	//setting data for all fields (including embedded fields)
    	User returnedUser = new User();
    	returnedUser.setName(user.getName());
    	returnedUser.setUsername(user.getUsername());
    	returnedUser.setEmail(user.getEmail());
    	returnedUser.setPhone(user.getPhone());
    	returnedUser.setWebsite(user.getWebsite());
    	returnedUser.setAddress(user.getAddress());
    	returnedUser.setCompany(user.getCompany());
    	
    	return returnedUser;
    }

    //type Iterable as it iterates through the users.json file to load default user data
    public Iterable<User> listUsers() { 
        return userRepository.findAll();
    }
    
    public Optional<User> listUser(long id) {
    	return userRepository.findById(id);
    }

    public User updateUser(long id, User user) {
    	//user is found by their id
        User existingUser = userRepository.findById(id)
        		.orElseThrow(() -> new UserNotFoundException("Unfortunately this user does not exist."));
        //then the existing user's information is updated if it was changed
        existingUser.setName(user.getName());
        existingUser.setUsername(user.getUsername());
        existingUser.setEmail(user.getEmail());
        existingUser.setPhone(user.getPhone());
        existingUser.setWebsite(user.getWebsite());
        existingUser.setAddress(user.getAddress());
        existingUser.setCompany(user.getCompany());
        
        return existingUser;
    }
    
    public User save(User user) {
        return userRepository.save(user);
    }

    public void save(List<User> users) {
        userRepository.saveAll(users);
    }
    
    
    public void deleteUser(long id) {
    	//user is found by their id
        User existingUser = userRepository.findById(id)
        		.orElseThrow(() -> new UserNotFoundException("Unfortunately this user does not exist."));
    	//existing user is then deleted
        userRepository.delete(existingUser);
    }
    
    public void deleteUsers() {
    	userRepository.deleteAll();
    }
}
