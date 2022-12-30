package com.project.recycle.controller;

import com.project.recycle.model.Recipe;
import com.project.recycle.repository.RecipeRepository;
import com.project.recycle.service.RecipeService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class RecipeControllerTest {

    @Mock
    RecipeController controller;
    @Mock
    RecipeService service;

    @Test
    void saveRecipe() {
        Recipe recipe = new Recipe("vidrio","1. ASD\n2. ASD");
        when(service.saveRecipe(recipe)).thenReturn(recipe);
    }

    @Test
    void getRecipesTest(){
        Recipe recipe1 = new Recipe("vidrio","1. ASD\n2. ASD");
        Recipe recipe2 = new Recipe("vidrio","1. ASD\n2. ASD");
        Recipe recipe3 = new Recipe("vidrio","1. ASD\n2. ASD");

        List<Recipe> listSaved = new ArrayList<>();
        listSaved.add(recipe1);
        listSaved.add(recipe2);
        listSaved.add(recipe3);

        service.saveRecipe(recipe1);
        service.saveRecipe(recipe2);
        service.saveRecipe(recipe3);


        when(service.getRecipes()).thenReturn(listSaved);
    }

    @Test
    void getRecipesByClassificationTest(){
        Recipe recipe1 = new Recipe("vidrio","1. ASD\n2. ASD");
        Recipe recipe2 = new Recipe("latas","1. ASD\n2. ASD");
        Recipe recipe3 = new Recipe("latas","1. ASD\n2. ASD");

        List<Recipe> listSaved = new ArrayList<>();
        listSaved.add(recipe1);
        listSaved.add(recipe2);
        listSaved.add(recipe3);

        service.saveRecipe(recipe1);
        service.saveRecipe(recipe2);
        service.saveRecipe(recipe3);

        List<Recipe> listSavedReturn = listSaved.stream().filter(recipe -> recipe.getClassification().equals("latas")).toList();

        when(service.getRecipesByClassification("latas")).thenReturn(listSavedReturn);
    }

}