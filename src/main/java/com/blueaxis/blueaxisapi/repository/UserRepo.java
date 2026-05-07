package com.blueaxis.blueaxisapi.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.blueaxis.blueaxisapi.models.User;

public interface UserRepo extends MongoRepository<User, Long> {


	User findByEmail(String email);


	 User findByResetToken(String resetToken);

	User findByEmailAndPassword(String email,String password);
	
//    Optional<User> findbyEmail(String email);


}
