package com.blueaxis.blueaxisapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blueaxis.blueaxisapi.models.User;
import com.blueaxis.blueaxisapi.repository.UserRepo;


@Service
public class UserService {

	@Autowired
    private UserRepo repo;

    public User saveUser(User user){
        return repo.save(user);
    }
}
