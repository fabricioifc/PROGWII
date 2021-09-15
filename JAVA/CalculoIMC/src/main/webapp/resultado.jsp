<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>IMC - Resultado</title>
    </head>
    <body>
        <fieldset>
            <legend>Resultado</legend>
            <p>Nome: <%= request.getParameter("nome") %></p>
            <p>IMC: <%= request.getAttribute("imc") %></p>
            <p>Resultado: <%= request.getAttribute("condicao") %></p>
        </fieldset>
    </body>
</html>
