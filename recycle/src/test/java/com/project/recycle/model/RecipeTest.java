package com.project.recycle.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecipeTest {

    @Test
    void getId() {
        Recipe recipe = new Recipe();
        recipe.setId(1L);
        assertEquals(1L,recipe.getId());
    }

    @Test
    void setId() {
        Recipe recipe = new Recipe();
        recipe.setId(1L);
        assertEquals(1L,recipe.getId());
    }

    @Test
    void getClassification() {
        Recipe recipe = new Recipe();
        recipe.setClassification(Classification.GLASS);
        assertEquals("GLASS",recipe.getClassification().toString());
    }

    @Test
    void setClassification() {
        Recipe recipe = new Recipe();
        recipe.setClassification(Classification.GLASS);
        assertEquals("GLASS",recipe.getClassification().toString());
    }

    @Test
    void getSteps() {
        Recipe recipe = new Recipe();
        recipe.setSteps("1. ASD\n2. 123");
        assertEquals("1. ASD\n2. 123",recipe.getSteps());
    }

    @Test
    void setSteps() {
        Recipe recipe = new Recipe();
        recipe.setSteps("1. ASD\n2. 123");
        assertEquals("1. ASD\n2. 123",recipe.getSteps());
    }
}