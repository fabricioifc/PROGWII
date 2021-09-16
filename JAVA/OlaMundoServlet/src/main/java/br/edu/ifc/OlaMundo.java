package br.edu.ifc;

import java.io.IOException;
import java.io.PrintWriter;
import javax.json.JsonObject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet(name = "OlaMundo", urlPatterns = {"/", "/ifc/OlaMundo"})
@WebServlet(name = "OlaMundo", urlPatterns = "/ifc/OlaMundo")
public class OlaMundo extends HttpServlet {

    protected void processarRequisicao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String tipo = request.getParameter("tipo");
        switch (String.valueOf(tipo)) {
            case "html":
                emHtml(request, response);
                break;
            case "json":
                emJson(request, response);
                break;
            default:
                emHtml(request, response);
        }

    }

    private void emJson(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();
        out.println("{\"nome\": \"teste\"}");
    }

    private void emHtml(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>OlaMundo</title>");
        out.println("</head>");
        out.println();
        out.println("<body>");
        out.println("<h1>Ola Mundo!!!</h1>");

        out.println("Meu nome é "
                + request.getParameter("nome"));

        out.println("</body>");
        out.println("</html>");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processarRequisicao(request, response);
    }
}
