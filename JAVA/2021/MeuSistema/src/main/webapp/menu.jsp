<%@page import="java.util.LinkedHashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="br.edu.ifc.model.Usuario"%>
<%
    Usuario logado = (Usuario) request.getSession().getAttribute("usuarioLogado");

    Map<String, String> linksLogado = new LinkedHashMap<>();
    linksLogado.put("/MeuSistema/home.jsp", "Página Inicial");
    linksLogado.put("/MeuSistema/restrito/contas.xhtml", "Contas");
    linksLogado.put("/MeuSistema/logout", "Sair");

    Map<String, String> linksNaoLogado = new LinkedHashMap<>();
    linksNaoLogado.put("/MeuSistema/home.jsp", "Página Inicial");
    linksNaoLogado.put("/MeuSistema/login", "Login");
%>

<h1>Meu Sistema Financeiro Pessoal</h1>
<ul class="menu">

    <% if (logado != null) {
            for (Map.Entry<String, String> link : linksLogado.entrySet()) {
                out.println("<li><a href=\"" + link.getKey() + "\">" + link.getValue() + "</a></li>");
                out.println("|");
            }

        } else {
            for (Map.Entry<String, String> link : linksNaoLogado.entrySet()) {
                out.println("<li><a href=\"" + link.getKey() + "\">" + link.getValue() + "</a></li>");
                out.println("|");
            }
        }


    %>
</ul>

<hr />