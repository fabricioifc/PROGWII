<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form name="formulario" action="calcular" method="POST">
            Total de kilômetros rodados (km): <br />
            <input type="text" name="km" /> <br />
            Litros consumidos (litro): <br />
            <input type="text" name="litro" /> <br />
            Preço da Gasolina (preço/litro): <br />
            <input type="text" name="preco" /> <br />
            
            
            <input type="submit" value="Calcular km/l" />
        </form>
    </body>
</html>
