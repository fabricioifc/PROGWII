package br.com.ifc.filters;

import java.io.IOException;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(dispatcherTypes = {DispatcherType.REQUEST, DispatcherType.FORWARD}, urlPatterns = {"/login.jsp", "/registrar.jsp"})
public class PublicFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("Passou pelo filtro público!");

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        try {

            //Pega a sessão do usuário, caso exista
            HttpSession sessao = httpRequest.getSession(false);
            boolean logado = sessao != null && sessao.getAttribute("usuarioLogado") != null;
            System.out.println(logado);

            if (!logado) {
                //Siga em frente
                chain.doFilter(request, response);
            } else {
//                httpRequest.getRequestDispatcher("index.jsp").forward(request, response);
                httpResponse.sendRedirect("index.jsp");
            }

        } finally {

        }
    }

    @Override
    public void destroy() {
        System.out.println("Terminou o filtro público");
    }

}
