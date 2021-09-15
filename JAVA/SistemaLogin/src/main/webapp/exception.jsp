<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Acesso negado</title>
        <link rel="stylesheet" href="resources/bootstrap/css/bootstrap.min.css"/>
    </head>
    <body>
        <jsp:include page="menu.jsp" />
        <div class="container">
            <h3>Ocorreu um erro inesperado!</h3>
            <ul>
                <li>Classe: ${servletName}</li>
                <li>Tipo: ${errorName}</li>
                <li>Descrição: ${errorMessage}</li>
            </ul>
        </div>
    </body>
</html>