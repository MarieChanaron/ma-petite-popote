package fr.mariech.tp.resources;

import fr.mariech.tp.model.Recipe;
import fr.mariech.tp.service.RecipeService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

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


}
