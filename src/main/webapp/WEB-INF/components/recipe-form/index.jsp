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

<main id="recipe-form">

  <h3 class="text-center mt-5">Nouvelle recette</h3>

  <div class="container">
    <div class="row">
      <div class="col-6 mx-auto my-5">
        <form method="post" action="login">
          <div class="mb-3">
            <label for="name" class="form-label">Nom</label>
            <input type="text" class="form-control" id="name" aria-describedby="emailHelp" name="name">
          </div>
          <div class="mb-3">
            <label for="image" class="form-label">Image</label>
            <input type="text" class="form-control" id="image" name="image" aria-describedby="emailHelp">
          </div>
          <div class="mb-3">
            <label for="category" class="form-label">Catégorie</label>
            <select class="form-select" aria-label="Default select example" id="category" name="category">
              <option value="tout" selected>Toutes les catégories</option>
              <option value="entree">Entrée</option>
              <option value="plat">Plat</option>
              <option value="dessert">Dessert</option>
            </select>
          </div>
          <div class="mb-3">
            <label for="content" class="form-label">Recette</label>
            <textarea class="form-control" id="content" name="content" placeholder="Your content.." style="height: 300px"></textarea>
          </div>
          <button type="submit" class="btn-plain brown">Soumettre</button>
        </form>
      </div>
    </div>
  </div>

</main>


</body>

</html>