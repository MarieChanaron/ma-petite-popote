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
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
</head>

<body>

<main id="admin-recipes" class="my-5">

  <a href="add-recipe" class="no-underline fit-content">
    <button class="btn-plain brown block-center my-5" type="submit">Ajouter recette</button>
  </a>

  <div class="container">
    <div class="row">

      <c:import url="/content" />

      <c:forEach var="recipe" items="${recipes}">
        <div class="col-4 my-2">
          <div class="card">
            <img src="${recipe.getImage()}" class="card-img-top" alt="...">
            <div class="card-body">
              <p class="card-text m-0">${recipe.getName()}</p>
              <p class="card-text m-0 uppercase">${recipe.getCategory().getName()}</p>
              <p class="m-0">
                <a href="edit-recipe?id=${recipe.getId()}&name=${recipe.getName()}"><svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"><path fill="currentColor" d="M6 22q-.825 0-1.413-.588T4 20V4q0-.825.588-1.413T6 2h7.175q.4 0 .763.15t.637.425l4.85 4.85q.275.275.425.638t.15.762V11.1l-8 7.975V22H6Zm8.5 0q-.2 0-.35-.15T14 21.5v-1.2q0-.2.088-.4t.212-.325l4.85-4.875l2.15 2.1l-4.875 4.9q-.125.15-.325.225t-.4.075h-1.2Zm7.525-5.9L19.9 13.975l.7-.7q.3-.3.725-.3t.7.3l.7.725q.275.3.275.713t-.275.687l-.7.7ZM14 9h4l-5-5v4q0 .425.288.713T14 9Z"/></svg></a>
                <a href="remove-recipe?id=${recipe.getId()}" class="ps-2"><svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 256 256"><path fill="currentColor" d="M216 48h-40v-8a24 24 0 0 0-24-24h-48a24 24 0 0 0-24 24v8H40a8 8 0 0 0 0 16h8v144a16 16 0 0 0 16 16h128a16 16 0 0 0 16-16V64h8a8 8 0 0 0 0-16ZM112 168a8 8 0 0 1-16 0v-64a8 8 0 0 1 16 0Zm48 0a8 8 0 0 1-16 0v-64a8 8 0 0 1 16 0Zm0-120H96v-8a8 8 0 0 1 8-8h48a8 8 0 0 1 8 8Z"/></svg></a>
              </p>
            </div>
          </div>
        </div>
      </c:forEach>

    </div>
  </div>

</main>


</body>

</html>