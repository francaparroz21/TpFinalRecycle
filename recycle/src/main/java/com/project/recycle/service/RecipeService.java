package com.project.recycle.service;

import com.project.recycle.repository.RecipeRepository;
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

    public List<Recipe> getRecipesByClassification(String classification) {
        return repository.findByClassification(classification);
    }

    public boolean deleteRecipe(Long id){
        try{
            repository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
