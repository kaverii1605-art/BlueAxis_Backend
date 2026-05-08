package com.blueaxis.blueaxisapi.controllers;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blueaxis.blueaxisapi.models.User;
import com.blueaxis.blueaxisapi.repository.UserRepo;
import com.blueaxis.blueaxisapi.services.EmailService;
import com.blueaxis.blueaxisapi.services.UserService;


@RestController
@RequestMapping("/api")
//@CrossOrigin("*")
public class Usercotroller {

	@Autowired
	private UserRepo repo;
	

	@Autowired
	private UserService service;
	
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@PostMapping("/login")
	public ResponseEntity<Map<String,String>> login(@RequestBody User user){

	    Map<String,String> response = new HashMap<>();

	    String token = service.login(user.getEmail(), user.getPassword());

	    if(token != null){

	        response.put("message","Login successful");
	        response.put("token", token);

	        return ResponseEntity.ok(response);

	    } else {

	        response.put("message","Invalid email or password");

	        return ResponseEntity.status(401).body(response);
	    }
	}
	

//	    @PostMapping("/register")
//	    public Map<String,String> register(@RequestBody User user){
//	    	System.out.println("REGISTER API HIT");
//
//	        service.saveUser(user);
//
//	        Map<String,String> response = new HashMap<>();
//	        response.put("message","User registered successfully");
//
//	        return response;
//	    }
	
	@PostMapping("/register")
	public ResponseEntity<Map<String,String>> register(@RequestBody User user){

	    System.out.println("REGISTER API HIT");

	    Map<String,String> response = new HashMap<>();

	    try {
	        service.saveUser(user);

	        response.put("message", "User registered successfully");
	        return ResponseEntity.ok(response);

	    } catch (Exception e) {
	        e.printStackTrace();

	        response.put("message", e.getMessage());
	        return ResponseEntity.status(500).body(response);
	    }
	}
	    
	    
	    @PostMapping("/forgot-password")
	    public Map<String, String> forgotPassword(@RequestBody Map<String, String> request) {

	        String email = request.get("email");

	        User user = repo.findByEmail(email);

	        if (user == null) {
	            return Map.of("message", "Email not found");
	        }

	        String token = UUID.randomUUID().toString();

	        user.setResetToken(token);
	        repo.save(user);

	        String resetLink = "http://127.0.0.1:5501/reset-password.html?token=" + token;
	        String vercelLink = "https://newdeployment-two.vercel.app/reset-password.html?token=" + token;

	        String liveLink = "https://blueaxismedia.in/reset-password.html?token=" + token;


	        String message = "Hello,\n\n"
	                + "Click the link below to reset your password:\n"
	                + resetLink + "\n\n"
	                
	                + "Live Website:\n"
	                + liveLink + "\n\n"

	                + "Local Testing:\n"
	                + vercelLink + "\n\n"
	                + "If you did not request this, please ignore this email.";

	        emailService.sendEmail(email, "Reset Your Password", message);

	        return Map.of("message", "Reset password link sent to your email");
	    }
	    
	    
	    @PostMapping("/reset-password")
	    public Map<String, String> resetPassword(@RequestBody Map<String, String> request) {

	        String token = request.get("token");
	        String newPassword = request.get("password");

	        User user = repo.findByResetToken(token);

	        if (user == null) {
	            return Map.of("message", "Invalid or expired reset link");
	        }

	        user.setPassword(passwordEncoder.encode(newPassword));
	        user.setResetToken(null);

	        repo.save(user);

	        return Map.of("message", "Password reset successfully");
	    }
	    
}
	    
//	    @PostMapping("/login")
//	    public ResponseEntity<Map<String,String>> login(@RequestBody User user){
//
//	    	
//
//	        Map<String,String> response = new HashMap<>();
//
//	        if(existingUser != null){
//
//	            response.put("message","Login successful");
//
//	            return ResponseEntity.ok(response);
//
//	        } else {
//
//	            response.put("message","Invalid email or password");
//
//	            return ResponseEntity.status(401).body(response);
//	        }
//
//	    }}

	    
	    
//	    @PostMapping("/login")
//	    public ResponseEntity<Map<String,String>> login(@RequestBody User user){
//
//	        User existingUser = repo.findByEmailAndPassword(user.getEmail(), user.getPassword());
//
//	        Map<String,String> response = new HashMap<>();
//
//	        if(existingUser != null){
//
//	            response.put("message","Login successful");
//
//	            return ResponseEntity.ok(response);
//
//	        } else {
//
//	            response.put("message","Invalid email or password");
//
//	            return ResponseEntity.status(401).body(response);
//	        }
//
//	    }}

