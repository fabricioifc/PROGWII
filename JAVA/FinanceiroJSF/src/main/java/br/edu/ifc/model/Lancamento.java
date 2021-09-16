/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifc.model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author fabricio
 */
public class Lancamento implements Serializable{

    private Integer id;
    private Date dtlancamento;
    private String descricao;
    private String tipo = "Despesa";
    private Double valor;

    public Lancamento() {
    }

    public Lancamento(Date dtlancamento, String descricao, String tipo, Double valor) {
        this.dtlancamento = dtlancamento;
        this.descricao = descricao;
        this.tipo = tipo;
        this.valor = valor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDtlancamento() {
        return dtlancamento;
    }

    public void setDtlancamento(Date dtlancamento) {
        this.dtlancamento = dtlancamento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

}
