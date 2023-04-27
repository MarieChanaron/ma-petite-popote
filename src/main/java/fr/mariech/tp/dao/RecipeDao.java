package fr.mariech.tp.dao;

import fr.mariech.tp.model.Category;
import fr.mariech.tp.model.Recipe;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RecipeDao implements GenericRecipeDao {

    Connection connection = ConnectionManager.getInstance();

    @Override
    public Long add(Recipe entity) {
        return null;
    }

    @Override
    public List<Recipe> fetchAll() {
        String query = "SELECT recipe.id AS 'id', recipe.name as 'name', text, image, recipe.category AS 'category_id', category.name AS 'category_name' " +
                "FROM recipe " +
                "INNER JOIN category " +
                "ON recipe.category = category.id";
        List<Recipe> allRecipes = new ArrayList<>();
        Statement pst = null;
        ResultSet result = null;
        try {
            pst = connection.createStatement();
            result = pst.executeQuery(query);

            while (result.next()) {
                Recipe recipe = new Recipe(
                        result.getInt("id"),
                        result.getString("name"),
                        result.getString("text"),
                        result.getString("image"),
                        new Category(result.getLong("category_id"), result.getString("category_name"))
                );
                allRecipes.add(recipe);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                pst.close();
                result.close();
            } catch (SQLException | NullPointerException error) {
                error.printStackTrace();
            }
        }
        return allRecipes;
    }

    @Override
    public Recipe fetchElement(Recipe entity) {
        return null;
    }

    @Override
    public boolean updateElement(Recipe entity) {
        return false;
    }

    @Override
    public boolean deleteElement(Long id) {
        return false;
    }
}
