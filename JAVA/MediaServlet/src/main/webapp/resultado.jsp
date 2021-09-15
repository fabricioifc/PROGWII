<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Resultado</title>
        <link rel="stylesheet" href="resources/bootstrap/css/bootstrap.min.css" />
        <script src="resources/js/jquery.min.js"></script>
        <script src="resources/bootstrap/js/bootstrap.min.js"></script>
    </head>
    <body>
        <p class="well">
            <%= "A média do aluno "
                    + request.getParameter("nome") + " referente as notas ("
                    + request.getParameter("n1") + ", "
                    + request.getParameter("n2") + ", "
                    + request.getParameter("n3") + ", "
                    + request.getParameter("n4")
                    + ") foi de: " + request.getAttribute("media")%>
        </p>
        <p><a href="index.jsp">Página inicial</a></p>
    </body>
</html>
