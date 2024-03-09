package com.deepmetis.sandwichordermanagement.services;

import com.deepmetis.sandwichordermanagement.domain.entities.Ingredient;

import java.util.List;

public interface IngredientService {

    Ingredient save(Ingredient ingredient);

    Ingredient findByNameAndCategory(String name, String category);

    List<Ingredient> findAll();

    boolean existsByNameAndCategory(String name, String category);

}
