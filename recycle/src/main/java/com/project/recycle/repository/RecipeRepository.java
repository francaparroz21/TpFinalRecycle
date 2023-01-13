package com.project.recycle.repository;
import com.project.recycle.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe,Long>{

    List<Recipe> findByClassification(String classification);
}
