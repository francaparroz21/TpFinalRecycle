package com.project.recycle.Controller;

import com.project.recycle.Service.RecipeService;
import com.project.recycle.model.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecipeController {

    @Autowired
    private RecipeService service;
    @PostMapping("/recipe")
    public Recipe saveRecipe(@RequestBody Recipe recipe){
        return service.saveRecipe(recipe);
    }
}
