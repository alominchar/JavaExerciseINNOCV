package com.innocv.javaexercise.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;

import com.innocv.javaexercise.JavaExerciseApplication;
import com.innocv.javaexercise.entity.User;

@SpringBootTest(classes = JavaExerciseApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerTest {

	/**
	 * Variable for having a test rest template
	 */
	@Autowired
	private TestRestTemplate restTemplate;
	
	/**
	 * Variable for knowing the port
	 */
	@LocalServerPort
    private int port;

	/**
	 * Methode for getting the root URL of the application
	 * @return The root URL of the application
	 */
    private String getRootUrl() {
        return "http://localhost:" + port + "/api";
    }

    @Test
    public void contextLoads() {

    }
    
    /**
     * Method for testing {@link com.innocv.javaexercise.controller.UserController#getAllUsers()}
     */
    @Test
    public void testGetAllUsers() {
    	
    	HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/users",
        HttpMethod.GET, entity, String.class);  
        assertNotNull(response.getBody());
    }
    
    /**
     * Method for testing {@link com.innocv.javaexercise.controller.UserController#getUserById(Integer)}
     */
    @Test
    public void testGetUserById() {
        User user = restTemplate.getForObject(getRootUrl() + "/users/1", User.class);
        System.out.println(user.getName());
        assertNotNull(user);
    }
    
    /**
     * Method for testing {@link com.innocv.javaexercise.controller.UserController#createUser(User)}
     */
    @Test
    public void testCreateUser() {
    	User user = new User();
        user.setName("Test");
        user.setBirthdate(new Date());
        ResponseEntity<User> postResponse = restTemplate.postForEntity(getRootUrl() + "/users", user, User.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }
    
    /**
     * Method for testing {@link com.innocv.javaexercise.controller.UserController#updateUser(Integer, User)}
     */
    @Test
    public void testUpdateUser() {
        int id = 1;
        User user = restTemplate.getForObject(getRootUrl() + "/users/" + id, User.class);
        user.setName("Test");
        restTemplate.put(getRootUrl() + "/users/" + id, user);
        User updatedUser = restTemplate.getForObject(getRootUrl() + "/users/" + id, User.class);
        assertNotNull(updatedUser);
    }

    /**
     * Method for testing {@link com.innocv.javaexercise.controller.UserController#deleteUser(Integer)}
     */
    @Test
    public void testDeleteUser() {
         int id = 2;
         User user = restTemplate.getForObject(getRootUrl() + "/users/" + id, User.class);
         assertNotNull(user);
         restTemplate.delete(getRootUrl() + "/users/" + id);
         try {
              user = restTemplate.getForObject(getRootUrl() + "/users/" + id, User.class);
         } catch (final HttpClientErrorException ex) {
              assertEquals(ex.getStatusCode(), HttpStatus.NOT_FOUND);
         }
    }
	
}
