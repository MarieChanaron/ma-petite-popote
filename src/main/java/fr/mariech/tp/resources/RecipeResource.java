package fr.mariech.tp.resources;

import fr.mariech.tp.model.Category;
import fr.mariech.tp.model.Recipe;
import fr.mariech.tp.service.RecipeService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Path("/recipes")
public class RecipeResource {

    public final RecipeService recipeService = new RecipeService();


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response fetchAllRecipes() {
        List<Recipe> allRecipes = recipeService.fetchRecipes();
        return Response
                .status(Response.Status.OK)
                .entity(allRecipes)
                .build();
    }


    @Path("/{id}")
    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response fetchPost(@PathParam("id") long id) {
        Recipe recipe = recipeService.fetchById(id);
        Response.Status status;
        if (recipe.getId() != 0) {
            status = Response.Status.OK;
        } else {
            status = Response.Status.NOT_FOUND;
        }
        return Response
                .status(status)
                .entity(recipe)
                .build();
    }


    @POST
    @Produces(value = MediaType.APPLICATION_JSON)
    @Consumes(value = MediaType.APPLICATION_JSON)
    public Response createRecipe(RecipeDto dto) {

        long categoryId = 4; // Default value

        if (dto.getCategory() != null) {
            categoryId = dto.getCategory().getId();
        }

        Recipe newRecipe = recipeService.insertRecipe(dto.getName(), dto.getText(), dto.getImage(), categoryId);

        Response.Status status;
        if (newRecipe.getId() != 0) {
            status = Response.Status.CREATED;
        } else {
            status = Response.Status.BAD_REQUEST;
        }

        return Response
                .status(status)
                .entity(newRecipe)
                .build();
    }


    @Path("/{id}")
    @PUT
    @Produces(value = MediaType.APPLICATION_JSON)
    @Consumes(value = MediaType.APPLICATION_JSON)
    public Response amendPost(@PathParam("id") long recipeId, RecipeDto dto) {

        long categoryId = 4; // Default value

        if (dto.getCategory() != null) {
            categoryId = dto.getCategory().getId();
        }

        Recipe recipeFound = recipeService.fetchById(recipeId);

        Response.Status status;
        Recipe responseBody;

        // If post found : modify the post and send 200 OK
        // If post not found = create the post and send 201 CREATED
        if (recipeFound.getId() == 0) {
            responseBody = recipeService.insertRecipe(dto.getName(), dto.getText(), dto.getImage(), categoryId);
            if (responseBody.getId() != 0) {
                status = Response.Status.CREATED;
            } else {
                status = Response.Status.BAD_REQUEST;
            }
        } else {
            boolean success = recipeService.updateRecipe(recipeId, dto.getName(), dto.getText(), dto.getImage(), categoryId);
            if (success) {
                status = Response.Status.OK;
            } else {
                status = Response.Status.NOT_MODIFIED;
            }
            responseBody = recipeFound;
        }

        return Response
                .status(status)
                .entity(responseBody)
                .build();
    }


    @Path("/{id}")
    @DELETE
    @Consumes(value = MediaType.APPLICATION_JSON)
    public Response deletePost(@PathParam("id") long id) {

        boolean success = recipeService.deleteRecipe(id);

        Response.Status status;
        if (success) {
            status = Response.Status.OK;
        } else {
            status = Response.Status.BAD_REQUEST;
        }

        return Response
                .status(status)
                .build();
    }

}
