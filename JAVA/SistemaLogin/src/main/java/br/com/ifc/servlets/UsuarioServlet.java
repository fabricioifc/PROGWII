/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifc.servlets;

import br.com.ifc.entidades.Usuarios;
import br.com.ifc.services.UsuarioService;
import br.com.ifc.services.UsuarioServiceImpl;
import br.com.ifc.utils.MD5Util;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/Usuarios")
public class UsuarioServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static String INSERIR_OU_EDITAR = "/restrito/usuario.jsp";
    private static String LISTAR_USUARIOS = "/restrito/usuarios.jsp";
    private UsuarioService service;

    public UsuarioServlet() {
        super();
        service = new UsuarioServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String forward = "";
            String action = request.getParameter("acao");

            if (action.equalsIgnoreCase("deletar")) {
                int userId = Integer.parseInt(request.getParameter("id"));
                verificarUsuarioLogado(request, userId);
                service.deletar(userId);
                forward = LISTAR_USUARIOS;
                request.setAttribute("usuarios", service.listar());
            } else if (action.equalsIgnoreCase("editar")) {
                forward = INSERIR_OU_EDITAR;
                int userId = Integer.parseInt(request.getParameter("id"));
                Usuarios usuario = service.getById(userId);
                request.setAttribute("usuario", usuario);
            } else if (action.equalsIgnoreCase("listar")) {
                forward = LISTAR_USUARIOS;
                request.setAttribute("usuarios", service.listar());
            } else {
                forward = INSERIR_OU_EDITAR;
            }

            RequestDispatcher view = request.getRequestDispatcher(forward);
            view.forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
            request.getSession().setAttribute("mensagens", ex.getMessage());
            response.sendRedirect(request.getHeader("Referer"));
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Usuarios usuario = new Usuarios();
            usuario.setNome(request.getParameter("nome"));
            usuario.setEmail(request.getParameter("email"));
            usuario.setUsuario(request.getParameter("usuario"));
            //Criptografar a senha para gravar no banco de dados
            usuario.setSenha(MD5Util.criptografar(request.getParameter("senha")));

            String id = request.getParameter("id");
            if (id == null || id.isEmpty()) {
                service.salvar(usuario);
            } else {
                usuario.setId(Integer.parseInt(id));
                service.atualizar(usuario);
            }
            RequestDispatcher view = request.getRequestDispatcher(LISTAR_USUARIOS);
            request.setAttribute("usuarios", service.listar());
            view.forward(request, response);
        } catch (Exception ex) {
            request.getSession().setAttribute("mensagens", ex.getMessage());
            response.sendRedirect(request.getHeader("Referer"));
        }
    }

    private void verificarUsuarioLogado(HttpServletRequest request, Integer userId) throws Exception {
        if (request.getSession() != null && request.getSession().getAttribute("usuarioLogado") != null) {
            Usuarios u = (Usuarios) request.getSession().getAttribute("usuarioLogado");
            if (u.getId().equals(userId)) {
                throw new Exception("O usuário logado não pode ser removido!");
            }
        }
    }

}
