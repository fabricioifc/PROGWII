<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String mensagens = (String) request.getAttribute("mensagens");
    String email = "";

    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
        for (int i = 0; i < cookies.length; i++) {
            if (cookies[i].getName().equals("meu_email")) {
                email = cookies[i].getValue();
                break;
            }

        }
    }
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login - IFC</title>
        <link rel="stylesheet" type="text/css" href="css/estilos.css" />
    </head>
    <body>
        <div>
            <jsp:include page="menu.jsp" />
        </div>
        
        <div>
            <h3>Login Page</h3>


            <p><%= mensagens%></p>

            <form action="login" method="POST">
                <label for="email">E-mail: </label>
                <input type="text" value="<%= email%>" name="email" placeholder="E-mail" autofocus />
                <label for="email">Senha: </label>
                <input type="password" value="" name="senha" placeholder="Senha" />

                <input type="checkbox" name="lembrar_email" checked="true" /> Lembrar de mim

                <br />
                <br />
                <input type="submit" value="Acessar" />


            </form>
        </div>
    </body>
</html>
