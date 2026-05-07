package com.blueaxis.blueaxisapi.models;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.*;

@Document(collection = "users")

public class User {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String username;
    private String password;
    private String role;
    private String resetToken;

    public String getResetToken() {
		return resetToken;
	}

	public void setResetToken(String resetToken) {
		this.resetToken = resetToken;
	}

	public User(){}

    public Long getId(){ return id; }

    public String getEmail(){ return email; }
    public void setEmail(String email){ this.email=email; }

    public String getUsername(){ return username; }
    public void setUsername(String username){ this.username=username; }

    public String getPassword(){ return password; }
    public void setPassword(String password){ this.password=password; }

    public String getRole(){ return role; }
    public void setRole(String role){ this.role=role; }

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", username=" + username + ", password=" + password + ", role="
				+ role + "]";
	}
    
    
}