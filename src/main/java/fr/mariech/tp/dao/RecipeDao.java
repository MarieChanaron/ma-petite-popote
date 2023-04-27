package fr.mariech.tp.dao;

import fr.mariech.tp.model.Category;
import fr.mariech.tp.model.Recipe;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class RecipeDao implements GenericRecipeDao {

    Connection connection = ConnectionManager.getInstance();

    @Override
    public long add(Recipe entity) {
        long id = 0;
        String name = entity.getName();
        String text = entity.getText();
        Long category = entity.getCategory().getId();
        String image = entity.getImage();
        String query = "INSERT INTO recipe (name, text, category, image) VALUES (?,?,?,?)";
        try (PreparedStatement myPreparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            myPreparedStatement.setString(1, name);
            myPreparedStatement.setString(2, text);
            myPreparedStatement.setLong(3, category);
            myPreparedStatement.setString(4, image);
            int rowsAffected = myPreparedStatement.executeUpdate();

            if (rowsAffected == 1) {
                ResultSet generatedKeys = myPreparedStatement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    id = generatedKeys.getLong(1);
                }
            }
        } catch (SQLException | NullPointerException error) {
            error.printStackTrace();
        }
        return id;
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
    public Recipe fetchElement(Recipe recipe) {
        String query = "SELECT * FROM recipe WHERE id = ?;";

        try (PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setLong(1, recipe.getId());
            ResultSet result = pst.executeQuery();
            System.out.println(pst);

            if (result.next()) {
                recipe.setId(result.getLong("id"));
                recipe.setName(result.getString("name"));
                recipe.setImage(result.getString("image"));
                recipe.setText(result.getString("text"));
                recipe.setCategory(new Category(result.getLong("category_id"), result.getString("category_name")));
            }
        } catch (SQLException | NullPointerException e) {
            e.printStackTrace();
        }
        return recipe;
    }

    @Override
    public boolean updateElement(Recipe entity) {
        boolean success = false;
        String query = "UPDATE recipe " +
                "SET recipe.name = ?, recipe.text = ?, recipe.image = ?, recipe.category = ? " +
                "WHERE recipe.id = ?;";
        try (PreparedStatement pst = connection.prepareStatement(query);) {
            pst.setString(1, entity.getName());
            pst.setString(2, entity.getText());
            pst.setString(3, entity.getImage());
            pst.setLong(4, entity.getCategory().getId());
            pst.setLong(5, entity.getId());
            pst.executeUpdate();
            success = true;
        } catch (SQLException error) {
            error.printStackTrace();
        }
        return success;
    }

    @Override
    public boolean deleteElement(Long id) {
        return false;
    }
}
