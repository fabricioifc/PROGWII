package controller;

import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import model.Conta;
import repository.CRUD;
import repository.ContaRepository;

/**
 * Controller para a classe contas
 *
 * @author fabricio
 */
@ManagedBean
@RequestScoped
public class ContaController implements Serializable {

//    private String titulo = "Dinheiro";
//    private Double saldoInicial;
    private Conta conta;
    private List<Conta> contas;
    private CRUD repository;

    public ContaController() {
        try {
            conta = new Conta();
            repository = new ContaRepository();
            contas = repository.listar();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("ERRO", e.getMessage()));
        }
    }

    public String cancelar() {
        return "contas";
    }

    public String salvar() {
        // IMPLEMENTAR
        throw new UnsupportedOperationException("IMPLEMENTAR ESSE METODO.");
    }

    public String alterar() {
        // IMPLEMENTAR
        throw new UnsupportedOperationException("IMPLEMENTAR ESSE METODO.");
    }

    public String excluir() {
        // IMPLEMENTAR
        throw new UnsupportedOperationException("IMPLEMENTAR ESSE METODO.");
    }

//    public String salvar() {
//        // Implementar
//        return "contas";
//    }
//    public String alterar() {
//        return "contas_form";
//    }
//    public void excluir() {
//        try {
////            repository.excluir(conta.getId());
//        } catch (Exception e) {
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("ERRO", e.getMessage()));
//        }
//    }
    /*GET e SET*/
    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public List<Conta> getContas() {
        return contas;
    }

    public void setContas(List<Conta> contas) {
        this.contas = contas;
    }

}
