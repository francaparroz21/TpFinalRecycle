package com.project.recycle.controller;

import com.project.recycle.model.Recipe;
import com.project.recycle.repository.RecipeRepository;
import com.project.recycle.service.RecipeService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
class RecipeTest {

    @Autowired
    RecipeController controller;
    @Autowired
    RecipeRepository repository;

    @Test
    void saveRecipe() {
        Recipe recipeSaved = controller.saveRecipe(new Recipe("vidrio","1. ASD\n2. ASD"));
        Recipe recipeFinded = repository.findById(recipeSaved.getId()).get();

        assertNotNull(recipeFinded);
        assertEquals(recipeSaved.getId(),recipeFinded.getId());
    }

    @Test
    void getRecipes() {
        List<Recipe> list_recipes = new ArrayList<>();
        list_recipes.add(new Recipe("vidrio","1. ASD\n2. ASD"));
        list_recipes.add(new Recipe("latas","1. 123\n2. 123"));
        List<Recipe> listSaved = repository.saveAll(list_recipes);
        List<Recipe> recipesRepository = controller.getRecipes();

        assertEquals(listSaved.size(),recipesRepository.size());

        for (int i = 0; i<recipesRepository.size();i++){
            assertEquals(listSaved.get(i).getId(),recipesRepository.get(i).getId());
        }
    }

    @Test
    void getRecipesByClassification() {
        List<Recipe> listRecipes = new ArrayList<>();
        listRecipes.add(new Recipe("glass","1. ASD\n2. ASD"));
        listRecipes.add(new Recipe("glass","1. 123\n2. 123"));
        listRecipes.add(new Recipe("glass","1. 123\n2. 123"));
        listRecipes.add(new Recipe("metal","1. 123\n2. 123"));
        List<Recipe> listSaved = repository.saveAll(listRecipes);
        List<Recipe> listRepository = repository.findByClassification("glass");

        assertEquals(3,listRepository.size());
        for (int i = 0; i<listRepository.size();i++){
            assertEquals(listSaved.get(i).getId(),listRepository.get(i).getId());
        }
    }
}