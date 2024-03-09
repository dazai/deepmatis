package com.deepmetis.sandwichordermanagement.services.impl;

import com.deepmetis.sandwichordermanagement.domain.entities.Role;
import com.deepmetis.sandwichordermanagement.domain.entities.User;
import com.deepmetis.sandwichordermanagement.dto.request.AuthenticationRequest;
import com.deepmetis.sandwichordermanagement.dto.request.RegisterRequest;
import com.deepmetis.sandwichordermanagement.dto.response.AuthenticationResponse;
import com.deepmetis.sandwichordermanagement.dto.response.Token;
import com.deepmetis.sandwichordermanagement.services.AuthenticationService;
import com.deepmetis.sandwichordermanagement.services.JwtService;
import com.deepmetis.sandwichordermanagement.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public AuthenticationResponse register(RegisterRequest request) {
        var user = User.builder()
                .id(UUID.randomUUID().toString())
                .name(request.name())
                .email(request.email())
                .phoneNumber(request.phoneNumber())
                .password(passwordEncoder.encode(request.password()))
                .role(Role.USER)
                .build();
        userService.save(user);
        var token = Token.builder()
                .accessToken(jwtService.generateToken(user))
                .type("Bearer")
                .expiresIn(5)
                .build();
        return new AuthenticationResponse(user, token);
    }

    @Override
    public AuthenticationResponse login(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.email(),
                        request.password()
                )
        );
        var user = userService.findByEmail(request.email());
        var token = Token.builder()
                .accessToken(jwtService.generateToken(user))
                .type("Bearer")
                .expiresIn(5)
                .build();
        return new AuthenticationResponse(user, token);
    }
}
