package com.project.recycle.controller;

import com.project.recycle.model.Recipe;
import com.project.recycle.repository.RecipeRepository;
import com.project.recycle.service.RecipeService;
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
class RecipeTest {

    @Autowired
    RecipeController controller;
    @Autowired
    RecipeService service;
    @Autowired
    RecipeRepository repository;

    @Test
    void saveRecipe() {
        Recipe recipe = new Recipe("vidrio","1. ASD\n2. ASD");
        Recipe recipeSaved = controller.saveRecipe(recipe);
        Recipe recipeFinded = repository.findById(recipeSaved.getId()).get();
        assertNotNull(recipeFinded);
    }

    @Test
    void getRecipes() {
        List<Recipe> list_recipes = new ArrayList<>();
        list_recipes.add(new Recipe("vidrio","1. ASD\n2. ASD"));
        list_recipes.add(new Recipe("latas","1. 123\n2. 123"));
        List<Recipe> listSaved = repository.saveAll(list_recipes);
        List<Recipe> recipesRepository = controller.getRecipes();

        assertEquals(listSaved.size(),recipesRepository.size());
    }

    @Test
    void getRecipesByClassification() {
        List<Recipe> list_recipes = new ArrayList<>();
        list_recipes.add(new Recipe("vidrio","1. ASD\n2. ASD"));
        list_recipes.add(new Recipe("latas","1. 123\n2. 123"));
        list_recipes.add(new Recipe("latas","1. 123\n2. 123"));
        list_recipes.add(new Recipe("latas","1. 123\n2. 123"));
        List<Recipe> listSaved = repository.saveAll(list_recipes);
        List<Recipe> listRepository = repository.findByClassification("latas");

        assertEquals(3,listRepository.size());
    }
}