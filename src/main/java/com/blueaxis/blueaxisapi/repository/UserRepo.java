package com.blueaxis.blueaxisapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blueaxis.blueaxisapi.models.User;

public interface UserRepo extends JpaRepository<User, Long> {


	User findByEmail(String email);


	 User findByResetToken(String resetToken);

	User findByEmailAndPassword(String email,String password);
	
//    Optional<User> findbyEmail(String email);


}
