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

<main id="connexion">

    <h3 class="text-center mt-5">Connexion</h3>

    <div class="container">
        <div class="row">
            <div class="col-6 mx-auto my-5">
                <form method="post" action="login">
                    <div class="mb-3">
                        <label for="exampleInputEmail1" class="form-label">Identifiant</label>
                        <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
                    </div>
                    <div class="mb-3">
                        <label for="exampleInputPassword1" class="form-label">Mot de passe</label>
                        <input type="password" class="form-control" id="exampleInputPassword1">
                    </div>
                    <button type="submit" class="btn-plain brown">Submit</button>
                </form>
            </div>
        </div>
    </div>

</main>


</body>

</html>