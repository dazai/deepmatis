package com.deepmetis.sandwichordermanagement.controllers;

import com.deepmetis.sandwichordermanagement.config.exceptions.BadRequestException;
import com.deepmetis.sandwichordermanagement.dto.request.AuthenticationRequest;
import com.deepmetis.sandwichordermanagement.dto.request.RegisterRequest;
import com.deepmetis.sandwichordermanagement.dto.response.AuthenticationResponse;
import com.deepmetis.sandwichordermanagement.services.AuthenticationService;
import com.deepmetis.sandwichordermanagement.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authService;
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request) {
        if (userService.existsByEmail(request.email())){
            throw new BadRequestException("Email already exists!");
        }
        if (!Objects.equals(request.password(), request.confirmPassword())) {
            throw new BadRequestException("Password and confirm password do not match");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(authService.register(request));

    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }

    /*@PostMapping("/password/reset")
    public ResponseEntity<?> resetPassword(@RequestBody SingleFieldRequest email) {
        User user = userService.findByEmail(email.value());
        if (user == null) {
            throw new BadRequestException("No account with this email was found. Please consider registering first");
        }
        String newPassword = RandomStringUtils.random(10, true, true);
        user.setPassword(passwordEncoder.encode(newPassword));
        userService.save(user);
        emailSenderService.sendResetPasswordEmail(user.getName(), newPassword, email.value());
        return ResponseEntity.ok(new ApiResponse(true, "Please check your email for the new password"));
    }*/

}
