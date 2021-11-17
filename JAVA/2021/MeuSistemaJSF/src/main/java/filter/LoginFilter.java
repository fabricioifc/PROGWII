package filter;

import java.io.IOException;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
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
@WebFilter(dispatcherTypes = {DispatcherType.REQUEST, DispatcherType.FORWARD}, urlPatterns = "/faces/restrito/*")
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    /**
     * Veja aqui um outro exemplo de filter:
     * https://www.journaldev.com/7252/jsf-authentication-login-logout-database-example
     *
     * @param request
     * @param response
     * @param chain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("Passou pelo filtro!");

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        try {

            //Pega a sessão do usuário, caso exista
            HttpSession sessao = httpRequest.getSession(true);
            boolean logado = sessao.getAttribute("usuarioLogado") != null;
            System.out.println(logado);

            if (logado) {
                //Siga em frente
                chain.doFilter(request, response);
            } else {
//                httpResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED);
                httpResponse.sendRedirect(httpRequest.getContextPath() + "/faces/login.xhtml");
            }

        } finally {

        }

    }

    @Override
    public void destroy() {
        System.out.println("Terminou o filtro!");
    }

}
