package com.blueaxis.blueaxisapi.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blueaxis.blueaxisapi.models.User;
import com.blueaxis.blueaxisapi.repository.UserRepo;
import com.blueaxis.blueaxisapi.services.UserService;


@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class Usercotroller {

	@Autowired
	private UserRepo repo;
	
	 @Autowired
	    private UserService service;

	    @PostMapping("/register")
	    public Map<String,String> register(@RequestBody User user){

	        service.saveUser(user);

	        Map<String,String> response = new HashMap<>();
	        response.put("message","User registered successfully");

	        return response;
	    }
	    
	    
	    @PostMapping("/login")
	    public ResponseEntity<Map<String,String>> login(@RequestBody User user){

	        User existingUser = repo.findByEmailAndPassword(user.getEmail(), user.getPassword());

	        Map<String,String> response = new HashMap<>();

	        if(existingUser != null){

	            response.put("message","Login successful");

	            return ResponseEntity.ok(response);

	        } else {

	            response.put("message","Invalid email or password");

	            return ResponseEntity.status(401).body(response);
	        }

	    }}
