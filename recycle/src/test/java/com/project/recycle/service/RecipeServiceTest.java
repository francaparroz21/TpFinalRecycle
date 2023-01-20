package com.project.recycle.service;

import com.project.recycle.model.Classification;
import com.project.recycle.model.Recipe;
import com.project.recycle.repository.RecipeRepository;
import com.project.recycle.service.RecipeService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class RecipeServiceTest {

    @InjectMocks
    RecipeService service;
    @Mock
    RecipeRepository repository;

    @Test
    void saveRecipeTest(){
        Recipe recipe = new Recipe(Classification.GLASS,"1. 123\n2. 123");
        repository.save(recipe);
        when(repository.save(recipe)).thenReturn(recipe);
    }

    @Test
    void getRecipesTest(){
        Recipe recipe1 = new Recipe(Classification.GLASS,"1. ASD\n2. ASD");
        Recipe recipe2 = new Recipe(Classification.GLASS,"1. ASD\n2. ASD");
        Recipe recipe3 = new Recipe(Classification.GLASS,"1. ASD\n2. ASD");

        List<Recipe> listSaved = new ArrayList<>();
        listSaved.add(recipe1);
        listSaved.add(recipe2);
        listSaved.add(recipe3);

        repository.save(recipe1);
        repository.save(recipe2);
        repository.save(recipe3);


        when(repository.findAll()).thenReturn(listSaved);
    }

    @Test
    void getRecipesByClassificationTest(){
        Recipe recipe1 = new Recipe(Classification.GLASS,"1. ASD\n2. ASD");
        Recipe recipe2 = new Recipe(Classification.GLASS,"1. ASD\n2. ASD");
        Recipe recipe3 = new Recipe(Classification.GLASS,"1. ASD\n2. ASD");

        List<Recipe> listSaved = new ArrayList<>();
        listSaved.add(recipe1);
        listSaved.add(recipe2);
        listSaved.add(recipe3);

        repository.save(recipe1);
        repository.save(recipe2);
        repository.save(recipe3);

        ;
    }

    @Test
    void deleteRecipeTest(){
        Recipe recipe1 = new Recipe(Classification.GLASS,"1. ASD\n2. ASD");
        repository.save(recipe1);
        when(repository.findById(recipe1.getId())).thenReturn(Optional.of(recipe1));
        assertEquals(true,service.deleteRecipe(recipe1.getId()));
    }
}