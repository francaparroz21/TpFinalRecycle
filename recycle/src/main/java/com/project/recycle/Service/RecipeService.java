package com.project.recycle.Service;

import com.project.recycle.Repository.RecipeRepository;
import com.project.recycle.model.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeService {

    @Autowired
    private RecipeRepository repository;

    public Recipe saveRecipe(Recipe recipe){
        return repository.save(recipe);
    }

    public List<Recipe> getRecipes() {
        return repository.findAll();
    }
}
