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

  <main id="recipes" class="my-5">

    <div class="container">
      <div class="row">

        <c:import url="/content" />

        <c:forEach var="recipe" items="${recipes}">
            <div class="col-4 my-2">
              <a href="recipe?id=${recipe.getId()}" class="no-underline">
                <div class="card overflow-hidden">
                  <div class="img-container overflow-hidden" style="background-image: url(<c:url value="${recipe.getImage()}" />)">
                  </div>
                  <div class="card-body">
                    <p class="card-text m-0">${recipe.getName()}</p>
                    <p class="card-text m-0 uppercase">${recipe.getCategory().getName()}</p>
                  </div>
                </div>
              </a>
            </div>
        </c:forEach>

      </div>
    </div>

  </main>


</body>

</html>