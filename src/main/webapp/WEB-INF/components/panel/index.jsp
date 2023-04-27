<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<head>
    <%@include file="../../global-styles/import-styles.jsp"%> <!-- Bootstrap and Google Fonts -->
    <style>
        <%@include file="../../global-styles/global.css"%>
        <%@include file="style.css"%>
    </style>
</head>

<body>

    <aside>

            <section>
                <form action="search" method="get" class="px-3 py-5">
                    <div class="mb-3">
                        <select class="form-select" aria-label="Default select example" id="category" name="category">
                            <option value="tout" selected>Toutes les catégories</option>
                            <option value="entree">Entrée</option>
                            <option value="plat">Plat</option>
                            <option value="dessert">Dessert</option>
                        </select>
                    </div>
                    <div class="mb-3">
                        <input type="text" class="form-control" id="search" placeholder="Termes de recherche">
                    </div>
                    <button type="submit" class="btn-outline">Rechercher</button>
                </form>
            </section>

            <section>
                <a href="" class="no-underline">
                    <button class="btn-plain block-center" type="submit">Recette aléatoire</button>
                </a>
            </section>

            <section>
                <a href="" class="text-center background-white block-center"> > Gérer mes recettes < </a>
            </section>

    </aside>

</body>

</html>