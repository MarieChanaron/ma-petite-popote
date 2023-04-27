<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <%@include file="../import-styles.jsp"%> <!-- Bootstrap and Google Fonts -->
    <title>Ma Petite Popote | Accueil</title>
</head>

<body>

    <div class="page">
        <div class="container">
            <div class="row">
                <c:import url="./components/header.jsp" />
            </div>
            <div class="row">
                <div class="col">
                    <c:import url="./components/panel.jsp" />
                </div>
                <div class="col">
                    <c:import url="./components/content.jsp" />
                </div>
            </div>
        </div>
    </div>

    <div id="footer">
        <c:import url="./components/footer.jsp" />
    </div>

</body>

</html>