package com.project.recycle.model;
import jakarta.persistence.*;

@Entity
@Table(name = "recipe")
public class Recipe {

    @Id
    @GeneratedValue( strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String classification;
    @Column(nullable = false)
    private String steps;

    public Recipe(){}

    public Recipe(Long id, String classification, String steps) {
        this.id = id;
        this.classification = classification;
        this.steps = steps;
    }

    public Recipe(String classification, String steps) {
        this.classification = classification;
        this.steps = steps;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public String getSteps() {
        return steps;
    }

    public void setSteps(String steps) {
        this.steps = steps;
    }
}
