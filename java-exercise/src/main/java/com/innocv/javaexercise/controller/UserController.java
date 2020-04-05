package com.innocv.javaexercise.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.innocv.javaexercise.entity.User;
import com.innocv.javaexercise.exception.ResourceNotFoundException;
import com.innocv.javaexercise.repository.UserRepository;

/**
 * Class controller for the user entity
 * @author Abraham Lominchar
 *
 */
@RestController
@RequestMapping("/api")
public class UserController {

	/**
	 * User repository injection
	 */
	@Autowired
	private UserRepository userRepository;
	
	/**
	 * Method for getting all the users
	 * @return The list with all the users
	 */
	@GetMapping("/users")
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	/**
	 * Method for getting a specific user
	 * @param userId The id of the user that we want to find
	 * @return The result of the search with the data of the user that we wanted to find
	 * @throws ResourceNotFoundException The exception to throw when the user is not found
	 */
	@GetMapping("/users/{id}")
	public ResponseEntity<User> getUserById(@PathVariable(value="id") Integer userId) throws ResourceNotFoundException{
		
		User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));
		return ResponseEntity.ok(user);
	}
	
	/**
	 * Method for creating a new user
	 * @param user The entity with the user to create
	 * @return The user that has been created
	 */
	@PostMapping("/users")
	public User createUser(@Valid @RequestBody User user) {
		return userRepository.save(user);
	}
	
	/**
	 * Method for updating an existing user
	 * @param userId The id to find the user that we want to update
	 * @param userUpdateDetails The entity with the data we want to update
	 * @return The result of the update with the data we updated
	 * @throws ResourceNotFoundException The exception to throw when the user to update is not found
	 */
	@PutMapping("/users/{id}")
	public ResponseEntity<User> updateUser
		(@PathVariable(value="id") Integer userId, @Valid @RequestBody User userUpdateDetails ) throws ResourceNotFoundException{
		
		// Find the user to update
		User userToUpdate = userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));
		
		// Set the entity to update
		if(null != userUpdateDetails.getBirthdate()) {
			userToUpdate.setBirthdate(userUpdateDetails.getBirthdate());
		}
		if(null != userUpdateDetails.getName()) {
			userToUpdate.setName(userUpdateDetails.getName());
		}
		
		final User updatedUser = userRepository.save(userToUpdate);
		return ResponseEntity.ok(updatedUser);
		
	}
	
	/**
	 * Method for deleting an user
	 * @param userId The id of the user to delete
	 * @return One map with the result of the delete
	 * @throws ResourceNotFoundException The exception to throw when the user to delete is not found
	 */
	@DeleteMapping("/users/{id}")
	public Map<String, Boolean> deleteUser(@PathVariable(value="id") Integer userId) throws ResourceNotFoundException{
		
		// Find the user to delete
		User userToDelete = userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));
		
		// Delete the user from the database
		userRepository.delete(userToDelete);
		
		// Prepare the response of the delete
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		
		return response;
		
	}
	
}
