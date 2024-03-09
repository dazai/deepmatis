package com.deepmetis.sandwichordermanagement.dto.response;

import com.deepmetis.sandwichordermanagement.domain.entities.User;

public record AuthenticationResponse(
        User user,
        Token token
) {
}
