package com.taskflow.tasks.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.taskflow.tasks.dto.AuthResponse;
import com.taskflow.tasks.dto.LoginRequest;
import com.taskflow.tasks.dto.RegisterRequest;
import com.taskflow.tasks.dto.UserResponse;
import com.taskflow.tasks.entity.User;
import com.taskflow.tasks.repository.UserRepository;
import com.taskflow.tasks.security.JwtService;

@Service 
public class AuthService {

    private  UserRepository userRepository;
    private  PasswordEncoder passwordEncoder;
    private  AuthenticationManager authenticationManager;
   
    private  JwtService jwtService;

    // constructor injection for all four
      public AuthService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder,
                       AuthenticationManager authenticationManager,
                       JwtService jwtService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    public UserResponse register(RegisterRequest req) {
        String email = req.email().trim().toLowerCase();
        if (userRepository.existsByEmail(email)) {
            return new UserResponse(0L, "Email already registered", email);
            
        }
        User user = new User();
        user.setName(req.name().trim());
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(req.password()));
        User saved = userRepository.save(user);
        return new UserResponse(saved.getId(), saved.getName(), saved.getEmail());
    }

    public AuthResponse login(LoginRequest req) {
        String email = req.email().trim().toLowerCase();
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(email, req.password()));
        User user = (User) userRepository.findByEmail(email);
        String token = jwtService.generateToken(email);
        return new AuthResponse(token,
            new UserResponse(user.getId(), user.getName(), user.getEmail()));
    }
}