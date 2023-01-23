package com.project.recycle.model;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "recipe")
public class Recipe {

    @Id
    @GeneratedValue( strategy= GenerationType.IDENTITY)
    private Long id;
    @Column
    @NotNull(message = "The classification attribute cannot be null")
    @Enumerated
    private Classification classification;
    @Column
    @NotNull(message = "The steps attribute cannot be null")
    private String steps;

    public Recipe(){}

    public Recipe(Long id, Classification classification, String steps) {
        this.id = id;
        this.classification = classification;
        this.steps = steps;
    }

    public Recipe(Classification classification, String steps) {
        this.classification = classification;
        this.steps = steps;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Classification getClassification() {
        return classification;
    }

    public void setClassification(Classification classification) {
        this.classification = classification;
    }

    public String getSteps() {
        return steps;
    }

    public void setSteps(String steps) {
        this.steps = steps;
    }
}
