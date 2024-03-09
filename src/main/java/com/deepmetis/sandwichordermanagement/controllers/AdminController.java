package com.deepmetis.sandwichordermanagement.controllers;

import com.deepmetis.sandwichordermanagement.config.annotations.HasRole;
import com.deepmetis.sandwichordermanagement.domain.entities.Ingredient;
import com.deepmetis.sandwichordermanagement.dto.request.NewIngredientRequest;
import com.deepmetis.sandwichordermanagement.dto.response.ApiResponse;
import com.deepmetis.sandwichordermanagement.services.IngredientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final IngredientService ingredientService;

    @PostMapping("/ingredient/add")
    @HasRole("ADMIN")
    public ResponseEntity<?> addNewIngredient(@RequestBody NewIngredientRequest request) {
        Ingredient ingredient;
        if (ingredientService.existsByNameAndCategory(request.name(), request.category())) {
            ingredient = ingredientService.findByNameAndCategory(request.name(), request.category());
            ingredient.setQuantity(request.quantity());
            ingredientService.save(ingredient);
            return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse("Updated Ingredient Quantity", true));
        }
        ingredient = Ingredient.builder()
                .id(UUID.randomUUID().toString())
                .name(request.name())
                .price(request.price())
                .quantity(request.quantity())
                .category(request.category())
                .build();
        ingredientService.save(ingredient);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse("Ingredient Added", true));
    }

}
