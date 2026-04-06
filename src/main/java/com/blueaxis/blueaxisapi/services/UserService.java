package com.blueaxis.blueaxisapi.services;
<<<<<<< HEAD
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
=======

import org.springframework.beans.factory.annotation.Autowired;
>>>>>>> 5ded778dd94c2a4d834ffcf431c557ed4fb43775
import org.springframework.stereotype.Service;

import com.blueaxis.blueaxisapi.models.User;
import com.blueaxis.blueaxisapi.repository.UserRepo;
<<<<<<< HEAD
import com.blueaxis.blueaxisapi.security.JwtUtil;
=======

>>>>>>> 5ded778dd94c2a4d834ffcf431c557ed4fb43775

@Service
public class UserService {

<<<<<<< HEAD
    @Autowired
    private UserRepo repo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    // ✅ REGISTER
    public void saveUser(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword())); // 🔐 encrypt
        user.setRole("USER");
        repo.save(user);
    }

    // ✅ LOGIN
    public String login(String email, String password){

        User existingUser = repo.findByEmail(email);

        if(existingUser != null &&
                passwordEncoder.matches(password, existingUser.getPassword())){

            return jwtUtil.generateToken(existingUser.getEmail());
        }

        return null;
    }
}
=======
	@Autowired
    private UserRepo repo;

    public User saveUser(User user){
        return repo.save(user);
    }
}
>>>>>>> 5ded778dd94c2a4d834ffcf431c557ed4fb43775
