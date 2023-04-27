<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <%@include file="global-styles/import-styles.jsp"%> <!-- Bootstrap and Google Fonts -->
    <style>
        <%@include file="global-styles/global.css"%>
    </style>
    <title>Ma Petite Popote | Accueil</title>
</head>

<body>

    <div class="page h-100">

        <c:import url="./components/header/" />

        <c:import url="./components/panel/" />

        <c:import url="./components/content/" />

        <%--div class="container-fluid">
            <div class="row">
                <div class="col-3 m-0 p-0">
                    <c:import url="./components/panel/" />
                </div>
                <div class="col-9 m-0 p-0">
                    <c:import url="./components/content/" />
                </div>
            </div>
        </div--%>

    </div>

    <div id="footer">
        <c:import url="./components/footer/" />
    </div>

</body>

</html>