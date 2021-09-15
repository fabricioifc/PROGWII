<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>Parâmetros</h2>
        <ul>
            <li>Foram percorridos <%= request.getParameter("km")%>
                quilômetros com <%= request.getParameter("litro")%> litros.</li>
            <li>O preço da gasolina é <%= request.getParameter("preco")%></li>
        </ul>

        <h2>Resultados obtidos</h2>        
        <ul>
            <li>Km/litro: <strong><%= request.getAttribute("resultado")%></strong></li>
            <li>Custo: <strong><%= request.getAttribute("custo")%></strong></li>
        </ul>
        <input type="button" value="Voltar" onclick="history.back()" />
    </body>
</html>
