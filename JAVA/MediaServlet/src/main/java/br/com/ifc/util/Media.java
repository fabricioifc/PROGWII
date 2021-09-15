/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifc.util;

import java.text.DecimalFormat;

/**
 *
 * @author fabricio
 */
public class Media {

    private final double notas[];

    public Media(double[] notas) {
        this.notas = notas;
    }

    public String calcularMedia() {
        DecimalFormat df = new DecimalFormat("#,##0.00");
        double soma = 0;
        for (int i = 0; i < notas.length; i++) {
            soma = soma + notas[i];
        }
        double media = soma / notas.length;
        return df.format(media);
    }

}
