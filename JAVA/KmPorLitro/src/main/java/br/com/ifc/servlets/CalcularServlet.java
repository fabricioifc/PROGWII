/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifc.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author fabricio
 */
@WebServlet(name = "calcular", urlPatterns = {"/calcular"})
public class CalcularServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String distancia = request.getParameter("km");
            String litro = request.getParameter("litro");
            String preco = request.getParameter("preco");

            CalcularUtil c = new CalcularUtil(distancia, litro, preco);

            request.setAttribute("resultado", c.calcularKmPorLitro());
            request.setAttribute("custo", c.calcularCusto());

            request.getRequestDispatcher("resultado.jsp").forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
