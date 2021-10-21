<%@page import="br.edu.ifc.model.Usuario"%>
<%
    Usuario logado = (Usuario) request.getSession().getAttribute("usuarioLogado");

    if (logado == null) {
        request.setAttribute("mensagens", "Acesso negado. Faça login.");
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Início - IFC</title>
        <link rel="stylesheet" type="text/css" href="css/estilos.css" />
    </head>
    <body>
        <div>
            <jsp:include page="menu.jsp" />
        </div>
        <div>
            <h3>Seja bem vindo <%= logado.getEmail()%>!</h3>
            <a href="logout">Sair</a>
        </div>
    </body>
</html>
