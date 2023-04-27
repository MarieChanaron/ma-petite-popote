<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <%@include file="../../global-styles/import-styles.jsp"%> <!-- Bootstrap and Google Fonts -->
    <style>
        <%@include file="../../global-styles/global.css"%>
        <%@include file="./style.css"%>
    </style>
</head>

<body>

<main id="edit-recipe-form">

    <c:import url="/get-recipe" />

    <h3 class="text-center mt-5">Modifier la recette</h3>

    <div class="container">
        <div class="row">
            <div class="col-6 mx-auto my-5">
                <form method="post" action="edit-recipe">
                    <div class="mb-3 d-none">
                        <label for="id" class="form-label">Id</label>
                        <input type="text" class="form-control" id="id" name="id" value="${recipe.getId()}">
                    </div>
                    <div class="mb-3">
                        <label for="name" class="form-label">Nom</label>
                        <input type="text" class="form-control" id="name" name="name" value="${recipe.getName()}">
                    </div>
                    <div class="mb-3">
                        <label for="image" class="form-label">Image</label>
                        <input type="text" class="form-control" id="image" name="image" aria-describedby="emailHelp" value="${recipe.getImage()}">
                    </div>
                    <div class="mb-3">
                        <label for="category" class="form-label">Catégorie</label>
                        <select class="form-select" aria-label="Default select example" id="category" name="category">
                            <c:if test="${recipe.getCategory().getId() == 4}">
                                <option value="4" selected>Toutes les catégories</option>
                                <option value="1">Entrée</option>
                                <option value="2">Plat</option>
                                <option value="3">Dessert</option>
                            </c:if>
                            <c:if test="${recipe.getCategory().getId() == 1}">
                                <option value="4">Toutes les catégories</option>
                                <option value="1" selected>Entrée</option>
                                <option value="2">Plat</option>
                                <option value="3">Dessert</option>
                            </c:if>
                            <c:if test="${recipe.getCategory().getId() == 2}">
                                <option value="4">Toutes les catégories</option>
                                <option value="1">Entrée</option>
                                <option value="2" selected>Plat</option>
                                <option value="3">Dessert</option>
                            </c:if>
                            <c:if test="${recipe.getCategory().getId() == 3}">
                                <option value="4">Toutes les catégories</option>
                                <option value="1">Entrée</option>
                                <option value="2">Plat</option>
                                <option value="3" selected>Dessert</option>
                            </c:if>

                        </select>
                    </div>
                    <div class="mb-3">
                        <label for="content" class="form-label">Recette</label>
                        <textarea class="form-control" id="content" name="content" placeholder="Your content.." style="height: 300px">${recipe.getText()}</textarea>
                    </div>
                    <button type="submit" class="btn-plain brown">Soumettre</button>
                </form>
            </div>
        </div>
    </div>

</main>


</body>

</html>