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

<main id="recipe" class="my-5">

  <div class="container">
    <div class="row">

      <div class="col-10 my-2 mx-auto overflow-hidden">
        <h3 class="text-center pb-3">${recipe.getName()}</h3>
        <div
                class="img-container overflow-hidden my-5"
                style="background-image: url(<c:url value="${recipe.getImage()}" />)">
        </div>
        <p>${recipe.getText()}</p>
        <p class="uppercase">Catégorie : ${recipe.getCategory().getName()}</p>
      </div>

    </div>
  </div>

</main>


</body>

</html>
