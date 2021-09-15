/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifc.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author fabricio
 */
@WebServlet(name = "CalcularIMC", urlPatterns = "/CalcularIMC")
public class CalcularIMC extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse resp)
            throws ServletException, IOException {
        if (request.getParameter("peso").equals("") || request.getParameter("altura").equals("")) {
            request.setAttribute("mensagens", "Informe peso e altura!");
            request.getRequestDispatcher("index.jsp").forward(request, resp);
        } else {
            Double peso = Double.parseDouble(request.getParameter("peso"));
            Double altura = Double.parseDouble(request.getParameter("altura"));
            String sexo = request.getParameter("sexo");

            Double imc = peso / (altura * altura);

            String condicao = null;

            if (sexo.equals("M")) {
                if (imc < 20.7) {
                    condicao = "Abaixo do peso";
                } else if (imc >= 20.7 && imc < 26.4) {
                    condicao = "No peso normal";
                } else if (imc >= 26.4 && imc < 27.8) {
                    condicao = "marginalmente acima do peso";
                } else if (imc >= 27.8 && imc < 31.1) {
                    condicao = "acima do peso ideal";
                } else if (imc >= 31.1) {
                    condicao = "obeso";
                }
            } else if (sexo.equals("F")) {
                if (imc < 19.1) {
                    condicao = "Abaixo do peso";
                } else if (imc >= 19.1 && imc < 25.8) {
                    condicao = "No peso normal";
                } else if (imc >= 25.8 && imc < 27.3) {
                    condicao = "marginalmente acima do peso";
                } else if (imc >= 27.3 && imc < 32.3) {
                    condicao = "acima do peso ideal";
                } else if (imc >= 32.3) {
                    condicao = "obeso";
                }
            }

            request.setAttribute("imc", imc);
            request.setAttribute("condicao", condicao);
            request.getRequestDispatcher("resultado.jsp").forward(request, resp);
        }
    }
}
