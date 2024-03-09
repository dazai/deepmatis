package com.deepmetis.sandwichordermanagement.controllers;

import com.deepmetis.sandwichordermanagement.domain.entities.Ingredient;
import com.deepmetis.sandwichordermanagement.services.IngredientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/ingredients")
@RequiredArgsConstructor
public class IngredientController {

    private final IngredientService ingredientService;

    @GetMapping("")
    public ResponseEntity<?> getAllIngredients() {
        var response = ingredientService.findAll()
                .stream()
                .collect(Collectors.groupingBy(Ingredient::getCategory));
        return ResponseEntity.ok(response);
    }
}
