package br.edu.ifc.controller;

import br.edu.ifc.model.Usuario;
import br.edu.ifc.repository.UsuarioRepository;
import br.edu.ifc.repository.UsuarioRepositoryInterface;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author fabricio
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    private UsuarioRepositoryInterface repository;

    @Override
    public void init() throws ServletException {
        repository = new UsuarioRepository();
    }

    @Override
    public void destroy() {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.sendRedirect("login.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            HttpSession sessao = request.getSession(true); //obtem a sessao do usuario, caso exista

            String email = request.getParameter("email"); // Pega o Login vindo do formulario
            String senha = request.getParameter("senha"); //Pega a senha vinda do formulario
            Usuario usuario = new Usuario(email, senha);

            // Mudar aqui quando adicionar banco de dados
//            boolean usuarioValido = "teste@gmail.com".equals(email) && "ifc".equals(senha);
            boolean usuarioValido = repository.validarUsuarioEmailSenha(usuario);

            if (usuarioValido) {
                sessao.setAttribute("usuarioLogado", usuario);
                //A sessão irá terminar em 2 minutos
                sessao.setMaxInactiveInterval(60 * 2);

                if (request.getParameter("lembrar_email") != null) {
                    Cookie c = new Cookie("meu_email", email);
                    response.addCookie(c);
                } else {
                    Cookie c = new Cookie("meu_email", null);
                    response.addCookie(c);
                }

                response.sendRedirect("home.jsp");
            } else {
                sessao.invalidate();
                request.setAttribute("mensagens", "Usuário e/ou senha inválido!");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException(e.getMessage());
//            response.sendError(HttpServletResponse.SC_BAD_REQUEST, e.getMessage());
        }
    }

}
