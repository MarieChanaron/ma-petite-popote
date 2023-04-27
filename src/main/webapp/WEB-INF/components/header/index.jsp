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

    <div class="container-fluid fixed-top" id="header">
        <div class="row py-3">
                <div class="col-6 d-flex align-items-center">
                    <a href="index" class="no-underline">
                        <img src="../../../images/60.png" alt="logo">
                        <p id="website-name" class="m-0 ps-3">Ma Petite Popote</p>
                    </a>
                </div>
            <div class="col-6 d-flex align-items-center justify-content-end">

                <c:choose>
                    <c:when test="${sessionScope.loggedIn}">
                        <a href="logout">
                            <button type="submit" class="btn-plain ms-3">Se déconnecter</button>
                        </a>
                    </c:when>
                    <c:otherwise>
                        <a href="subscription">
                            <button type="submit" class="btn-outline ms-3">S'inscrire</button>
                        </a>
                        <a href="connexion">
                            <button type="submit" class="btn-plain ms-3">Se connecter</button>
                        </a>
                    </c:otherwise>
                </c:choose>

            </div>
        </div>
    </div>

</body>

</html>