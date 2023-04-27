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
                <img src="../../../images/60.png" alt="logo">
                <p id="website-name" class="m-0 ps-3">Ma Petite Popote</p>
            </div>
            <div class="col-6 d-flex align-items-center justify-content-end">
                <button type="submit" class="btn btn-outline-success ms-3">S'inscrire</button>
                <button type="submit" class="btn btn-success ms-3">Se connecter</button>
            </div>
        </div>
    </div>

</body>

</html>