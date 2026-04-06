package com.blueaxis.blueaxisapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blueaxis.blueaxisapi.models.User;

public interface UserRepo extends JpaRepository<User, Long> {

<<<<<<< HEAD
	User findByEmail(String email);

}

=======
	User findByEmailAndPassword(String email,String password);

}
>>>>>>> 5ded778dd94c2a4d834ffcf431c557ed4fb43775
