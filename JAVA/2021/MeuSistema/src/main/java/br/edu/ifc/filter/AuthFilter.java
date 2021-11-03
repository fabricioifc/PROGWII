package br.edu.ifc.filter;

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

/**
 *
 * @author fabricio
 */
//@WebFilter(dispatcherTypes = {DispatcherType.REQUEST, DispatcherType.FORWARD}, urlPatterns = "/restrito/*")
public class AuthFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        try {
            HttpSession sessao = httpRequest.getSession(false);
            boolean logado = sessao != null && sessao.getAttribute("usuarioLogado") != null;
            System.out.println(logado);

            if (logado) {
                chain.doFilter(request, response); //Siga em frente
            } else {
                httpResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED);
            }

        } finally {

        }

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Passando pelo filtro - init");
    }

    @Override
    public void destroy() {
        System.out.println("Passando pelo filtro - destroy");
    }

}
