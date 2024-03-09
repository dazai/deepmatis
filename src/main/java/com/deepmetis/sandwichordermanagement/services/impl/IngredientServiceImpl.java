package com.deepmetis.sandwichordermanagement.services.impl;

import com.deepmetis.sandwichordermanagement.domain.entities.Ingredient;
import com.deepmetis.sandwichordermanagement.domain.repositories.IngredientRepository;
import com.deepmetis.sandwichordermanagement.services.IngredientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IngredientServiceImpl implements IngredientService {

    private final IngredientRepository ingredientRepository;

    @Override
    public Ingredient save(Ingredient ingredient) {
        return ingredientRepository.save(ingredient);
    }

    @Override
    public Ingredient findByNameAndCategory(String name, String category) {
        return ingredientRepository.findByNameAndCategory(name, category).orElse(null);
    }

    @Override
    public List<Ingredient> findAll() {
        return ingredientRepository.findAll();
    }

    @Override
    public boolean existsByNameAndCategory(String name, String category) {
        return ingredientRepository.existsByNameAndCategory(name, category);
    }
}
