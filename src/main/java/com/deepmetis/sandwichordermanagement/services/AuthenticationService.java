package com.deepmetis.sandwichordermanagement.services;

import com.deepmetis.sandwichordermanagement.dto.request.AuthenticationRequest;
import com.deepmetis.sandwichordermanagement.dto.request.RegisterRequest;
import com.deepmetis.sandwichordermanagement.dto.response.AuthenticationResponse;

public interface AuthenticationService {

    AuthenticationResponse register(RegisterRequest request);

    AuthenticationResponse login(AuthenticationRequest request);

}
