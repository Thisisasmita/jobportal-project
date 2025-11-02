package com.jobportal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.jobportal.dto.LoginRequestDTO;
import com.jobportal.dto.RegisterRequestDTO;
import com.jobportal.entity.User;
import com.jobportal.repository.UserRepository;
import com.jobportal.security.JWTUtil;

@Service
public class AuthService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
     @Autowired
    private JWTUtil jwtUtil;

    public String register(RegisterRequestDTO dto){
        if (userRepository.existsByName(dto.name) || userRepository.existsByEmail(dto.email)){
        throw new RuntimeException("User already exist");

    }
     User user = new User();
     user.setName(dto.getName());
     user.setEmail(dto.getEmail());
    user.setPassword(dto.getPassword());
     user.setRole(dto.getRole());


     userRepository.save(user);
     return "user registered successfully";

    
}
public String login(LoginRequestDTO dto){
    User user = userRepository.findByEmail(dto.email).orElseThrow(()-> new RuntimeException("user not found"));
    if(!passwordEncoder.matches(dto.password,user.getPassword())){
        throw new RuntimeException("Invalid credential");
    }
    return jwtUtil.generateToken(user);
}
}

