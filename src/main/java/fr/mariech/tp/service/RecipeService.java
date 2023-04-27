package fr.mariech.tp.service;

import fr.mariech.tp.dao.RecipeDao;
import fr.mariech.tp.model.Recipe;
import java.util.List;


public class RecipeService {

    RecipeDao recipeDao = new RecipeDao();

    public List<Recipe> fetchRecipes() {
        List<Recipe> allRecipes = recipeDao.fetchAll();
        return allRecipes;
    }
}
