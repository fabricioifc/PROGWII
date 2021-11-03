package br.edu.ifc.model;

/**
 *
 * @author fabricio
 */
public class Conta {

    private Integer id;
    private String titulo;
    private Double saldoInicial;

    public Conta(String titulo, Double saldoInicial) {
        this.titulo = titulo;
        this.saldoInicial = saldoInicial;
    }

    public Conta(Integer id, String titulo, Double saldoInicial) {
        this.id = id;
        this.titulo = titulo;
        this.saldoInicial = saldoInicial;
    }

    public Conta() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Double getSaldoInicial() {
        return saldoInicial;
    }

    public void setSaldoInicial(Double saldoInicial) {
        this.saldoInicial = saldoInicial;
    }

}
