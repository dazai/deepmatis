package com.deepmetis.sandwichordermanagement.dto.request;

public record OrderItem(
        String ingredient,
        float price
) {
}
