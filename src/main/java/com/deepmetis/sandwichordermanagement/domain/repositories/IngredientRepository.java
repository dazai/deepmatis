package com.deepmetis.sandwichordermanagement.domain.repositories;

import com.deepmetis.sandwichordermanagement.domain.entities.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, String> {

    boolean existsByNameAndCategory(String name, String category);

    Optional<Ingredient> findByNameAndCategory(String name, String category);

}
