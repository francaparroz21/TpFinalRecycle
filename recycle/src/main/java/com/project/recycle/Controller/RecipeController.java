package com.project.recycle.Controller;

import com.project.recycle.Service.RecipeService;
import com.project.recycle.model.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RecipeController {

    @Autowired
    private RecipeService service;
    @PostMapping("/recipes")
    public Recipe saveRecipe(@RequestBody Recipe recipe){
        return service.saveRecipe(recipe);
    }
    @GetMapping("/recipes")
    public List<Recipe> getRecipes(){return service.getRecipes();}

    @GetMapping("/recipes/{classification}")
    public List<Recipe> getRecipesByClassification(@PathVariable ("classification") String classification){
        return service.getRecipesByClassification(classification);
    }
}
