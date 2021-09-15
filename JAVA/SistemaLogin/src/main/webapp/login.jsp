<%-- 
    Document   : index
    Created on : 05/12/2016, 11:07:59
    Author     : fabricio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link rel="stylesheet" href="resources/bootstrap/css/bootstrap.min.css"/>
    </head>
    <body>
        <jsp:include page="menu.jsp" />
        <div class="container">
            <p class="well-sm bg-danger" ${mensagens == null ? 'hidden' : ''} >${mensagens}</p>
            <form method="post" action="Autenticador">
                <label for="usuario">Usuário:</label>
                <input type="text" name="usuario" value="" />
                <br />
                <label for="senha">Senha:</label>
                <input type="password" name="senha" value="" />
                <br /><br />
                <input type="submit" value="Acessar" />

            </form>
        </div>
    </body>
</html>
