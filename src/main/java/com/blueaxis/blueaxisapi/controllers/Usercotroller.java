package com.blueaxis.blueaxisapi.controllers;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
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
	    	
	    	user.setResetToken(UUID.randomUUID().toString());
	    	
	        service.saveUser(user);

	        response.put("message", "User registered successfully");
	        return ResponseEntity.ok(response);

	    } catch (Exception e) {
	        e.printStackTrace();

	        response.put("message", e.getMessage());
	        return ResponseEntity.status(500).body(response);
	    }
	}
	    
	
//	@GetMapping("/test")
//	public String test() {
//	    return "Backend updated";
//	}
	    
//	@PostMapping("/forgot-password")
//	public Map<String, String> forgotPassword(@RequestBody Map<String, String> request) {
//
//	    System.out.println("FORGOT PASSWORD API HIT");
//
//	    String email = request.get("email");
//
//	    User user = repo.findByEmail(email);
//
//	    System.out.println("USER FOUND");
//
//	    if (user == null) {
//	        return Map.of("message", "Email not found");
//	    }
//
//	    String token = UUID.randomUUID().toString();
//
//	    user.setResetToken(token);
//
//	    repo.save(user);
//
//	    System.out.println("TOKEN SAVED");
//
//	    String liveLink = "https://newdeployment-two.vercel.app/reset-password.html?token=" + token;
//	    String message = "Reset Password:\n" + liveLink;
//
//	    System.out.println("BEFORE EMAIL");
//
//	    emailService.sendEmail(email, "Reset Your Password", message);
//
//	    System.out.println("AFTER EMAIL");
//
//	    return Map.of("message", "Reset password link sent");
//	}	    
//	    
//	    @PostMapping("/reset-password")
//	    public Map<String, String> resetPassword(@RequestBody Map<String, String> request) {
//
//	        String token = request.get("token");
//	        String newPassword = request.get("password");
//
//	        User user = repo.findByResetToken(token);
//
//	        if (user == null) {
//	            return Map.of("message", "Invalid or expired reset link");
//	        }
//
//	        user.setPassword(passwordEncoder.encode(newPassword));
//	        user.setResetToken(null);
//
//	        repo.save(user);
//
//	        return Map.of("message", "Password reset successfully");
//	    }
//	    
	    
	@PostMapping("/update-password")
	public ResponseEntity<Map<String, String>> updatePassword(@RequestBody Map<String, String> request) {

	    Map<String, String> response = new HashMap<>();

	    try {
	        String token = request.get("token");
	        String newPassword = request.get("password");

	        User user = repo.findByResetToken(token);

	        if (user == null) {
	            response.put("message", "Invalid or expired reset link");
	            return ResponseEntity.status(400).body(response);
	        }

	        user.setPassword(passwordEncoder.encode(newPassword));
	        user.setResetToken(null);

	        repo.save(user);

	        response.put("message", "Password reset successfully");
	        return ResponseEntity.ok(response);

	    } catch (Exception e) {
	        e.printStackTrace();
	        response.put("message", e.getMessage());
	        return ResponseEntity.status(500).body(response);
	    }
	}	    
	    
	    @PostMapping("/send-reset-link")
	    public ResponseEntity<Map<String, String>> sendResetLink(@RequestBody Map<String, String> request) {

	        Map<String, String> response = new HashMap<>();

	        try {
	            String email = request.get("email");

	            User user = repo.findByEmail(email);

	            if (user == null) {
	                response.put("message", "Email not found");
	                return ResponseEntity.status(404).body(response);
	            }

	            String token = UUID.randomUUID().toString();
	            user.setResetToken(token);
	            repo.save(user);

	            String liveLink = "https://newdeployment-two.vercel.app/reset-password.html?token=" + token;
	            String message = "Reset Password:\n" + liveLink;
	            emailService.sendEmail(email, "Reset Your Password", message);
	            
	            

	            response.put("message", "Reset password link sent");
	            return ResponseEntity.ok(response);

	        } catch (Exception e) {
	            e.printStackTrace();
	            response.put("message", e.getMessage());
	            return ResponseEntity.status(500).body(response);
	        }
	    }
	    
	    
	    
	    @GetMapping("/version")
	    public Map<String, String> version() {
	        return Map.of("version", "backend-updated-10-may-2026");
	    }
	    
	    
	    
	    @GetMapping("/forgot-password-test")
	    public String forgotPasswordTest() {
	        return "forgot password public endpoint working";
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



