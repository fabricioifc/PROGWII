package br.com.ifc.servlets;

public class CalcularUtil {

    private final double distancia;
    private final double litros;
    private final double preco;

    public CalcularUtil(String distancia, String litros, String preco) {
        this.distancia = Double.parseDouble(distancia);
        this.litros = Double.parseDouble(litros);
        this.preco = Double.parseDouble(preco);
    }

    public double calcularKmPorLitro() throws Exception {
        double media = this.distancia / this.litros;
        return media;
    }
    
    public double calcularCusto() throws Exception {
        return this.litros * this.preco;
    }
}
