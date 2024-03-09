package com.deepmetis.sandwichordermanagement.dto.request;

public record NewIngredientRequest(
        String name,
        float price,
        int quantity,
        String category
) {
}
