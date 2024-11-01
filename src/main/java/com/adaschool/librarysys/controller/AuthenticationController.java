package com.adaschool.librarysys.controller;

import com.adaschool.librarysys.dto.UserRequest;
import com.adaschool.librarysys.dto.UserRequestLogin;
import com.adaschool.librarysys.dto.UserResponseLogin;
import com.adaschool.librarysys.models.User;
import com.adaschool.librarysys.service.auth.AuthenticationService;
import com.adaschool.librarysys.service.auth.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
@RestController
public class AuthenticationController {
    private final JwtService jwtService;
    private final AuthenticationService authenticationService;

    @PostMapping("/signup")
    public ResponseEntity<User> register(@RequestBody UserRequest registerUserDto) {
        User registeredUser = authenticationService.signup(registerUserDto);
        return new ResponseEntity<>(registeredUser, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<UserResponseLogin> authenticate(@RequestBody UserRequestLogin loginUserDto) {
        User authenticatedUser = authenticationService.login(loginUserDto);
        String jwtToken = jwtService.generateToken(authenticatedUser);

        UserResponseLogin loginResponse = new UserResponseLogin();
        loginResponse.setToken(jwtToken);
        loginResponse.setExpiresIn(jwtService.getExpirationTime());

        return new ResponseEntity<>(loginResponse, HttpStatus.OK);
    }
}
