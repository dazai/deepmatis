package com.deepmetis.sandwichordermanagement.dto.response;

import lombok.Builder;

@Builder
public record Token(
        String accessToken,
        String type,
        int expiresIn
) {
}
