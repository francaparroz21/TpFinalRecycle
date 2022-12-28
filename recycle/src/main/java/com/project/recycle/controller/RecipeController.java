package com.project.recycle.controller;

import com.project.recycle.service.RecipeService;
import com.project.recycle.model.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/recipes")
public class RecipeController {

    @Autowired
    private RecipeService service;
    @PostMapping
    public Recipe saveRecipe(@RequestBody Recipe recipe){
        return service.saveRecipe(recipe);
    }
    @GetMapping
    public List<Recipe> getRecipes(){return service.getRecipes();}

    @GetMapping("/{classification}")
    public List<Recipe> getRecipesByClassification(@PathVariable ("classification") String classification){
        return service.getRecipesByClassification(classification);
    }
}
