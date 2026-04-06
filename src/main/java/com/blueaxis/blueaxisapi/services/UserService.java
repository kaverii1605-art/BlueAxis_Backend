package com.blueaxis.blueaxisapi.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.blueaxis.blueaxisapi.models.User;
import com.blueaxis.blueaxisapi.repository.UserRepo;
import com.blueaxis.blueaxisapi.security.JwtUtil;

@Service
public class UserService {

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