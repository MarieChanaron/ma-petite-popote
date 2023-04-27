package fr.mariech.tp.service;

import fr.mariech.tp.dao.RecipeDao;
import fr.mariech.tp.model.Category;
import fr.mariech.tp.model.Recipe;

import java.util.List;


public class RecipeService {

    RecipeDao recipeDao = new RecipeDao();

    public List<Recipe> fetchRecipes() {
        List<Recipe> allRecipes = recipeDao.fetchAll();
        return allRecipes;
    }

    public Recipe fetchById(long id) {
        Recipe recipe = new Recipe(id);
        Recipe recipeFound = recipeDao.fetchElement(recipe);
        System.out.println(recipeFound);
        recipe.setName(recipeFound.getName());
        recipe.setCategory(recipeFound.getCategory());
        recipe.setImage(recipeFound.getImage());
        recipe.setText(recipeFound.getText());
        return recipe;
    }

    public Recipe insertRecipe(String name, String text, String image) {
        Category c = new Category(4L); // default
        Recipe recipe = new Recipe(name, text, image, c);
        long idRecipe = recipeDao.add(recipe);
        recipe.setId(idRecipe);
        return recipe;
    }

    public Recipe insertRecipe(String name, String text, String image, long categoryId) {
        Category c = new Category(categoryId);
        Recipe recipe = new Recipe(name, text, image, c);
        long idRecipe = recipeDao.add(recipe);
        recipe.setId(idRecipe);
        return recipe;
    }
}
