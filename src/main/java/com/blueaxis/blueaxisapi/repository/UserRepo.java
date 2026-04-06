package com.blueaxis.blueaxisapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blueaxis.blueaxisapi.models.User;

public interface UserRepo extends JpaRepository<User, Long> {

	User findByEmail(String email);

}

