package com.deepmetis.sandwichordermanagement.dto.request;

public record RegisterRequest(
        String name,
        String email,
        String phoneNumber,
        String password,
        String confirmPassword
) {
}
