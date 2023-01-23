package com.project.recycle.controller;

import com.project.recycle.service.RecipeService;
import com.project.recycle.model.Recipe;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/recipes")
public class RecipeController {

    @Autowired
    private RecipeService service;
    @PostMapping
    public ResponseEntity<Recipe> saveRecipe(@RequestBody Recipe recipe){
        return new ResponseEntity<>(service.saveRecipe(recipe), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<Recipe>> getRecipes(){return ResponseEntity.ok(service.getRecipes());}

    @GetMapping("/{classification}")
    @ApiOperation(value = "get recipes by classification", authorizations = {@Authorization(value = "JWT")})
    public ResponseEntity<List<Recipe>> getRecipesByClassification(@PathVariable ("classification") String classification){
        return ResponseEntity.ok(service.getRecipesByClassification(classification));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "delete a recipe", authorizations = {@Authorization(value = "JWT")})
    public ResponseEntity<Boolean> deleteRecipe(@PathVariable("id") Long id){
        return ResponseEntity.ok(service.deleteRecipe(id));
    }
}
