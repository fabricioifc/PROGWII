package br.edu.ifc.controller;

import br.edu.ifc.model.Conta;
import br.edu.ifc.repository.CRUD;
import br.edu.ifc.repository.ContaRepository;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

/**
 *
 * @author fabricio
 */
@javax.faces.bean.ViewScoped
@ManagedBean
public class ContaController implements Serializable {

    private CRUD<Conta> repository;
    private List<Conta> contas;
    private String teste = "Fabricio";

    public ContaController() {
        try {
            repository = new ContaRepository();
            contas = repository.listar();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public List<Conta> getContas() {
        return contas;
    }

    public void setContas(List<Conta> contas) {
        this.contas = contas;
    }

    public String getTeste() {
        return teste;
    }

    public void setTeste(String teste) {
        this.teste = teste;
    }

}
