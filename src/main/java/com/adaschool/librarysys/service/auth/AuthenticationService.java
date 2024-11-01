package com.adaschool.librarysys.service.auth;

import com.adaschool.librarysys.dto.UserRequest;
import com.adaschool.librarysys.dto.UserRequestLogin;
import com.adaschool.librarysys.models.User;
import com.adaschool.librarysys.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    @Value("${spring.profiles.active}")
    private String profile;

    public User signup(UserRequest userRequest) {
        User user = new User();
        user.setName(userRequest.getName());
        user.setUsername(userRequest.getUsername());
        user.setEmail(userRequest.getEmail());
        user.setPassword(passwordEncoder.encode(userRequest.getPassword()));
        user.setRol(userRequest.getRol());

        return userRepository.createUser(user);
    }

    public User login(UserRequestLogin userRequestLogin) {
        return userRepository.findUserByUsername(userRequestLogin.getUsername())
                .orElseThrow(() -> new EntityNotFoundException("error authenticating user, could not find user"));
    }
}