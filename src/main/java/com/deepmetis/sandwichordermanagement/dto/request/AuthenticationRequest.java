package com.deepmetis.sandwichordermanagement.dto.request;

public record AuthenticationRequest(
        String email,
        String password
) {
}
