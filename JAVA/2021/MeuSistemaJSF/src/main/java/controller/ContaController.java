package controller;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import model.Conta;
import model.Usuario;
import repository.CRUD;
import repository.ContaRepository;
import util.Mensagem;

/**
 * Controller para a classe contas
 *
 * @author fabricio
 */
@ManagedBean
@SessionScoped
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

    public String nova() {
        this.conta = new Conta();
        return "contas_form";
    }

    public String salvar() {
        try {

            HttpSession sessao
                    = (HttpSession) FacesContext.getCurrentInstance().
                            getExternalContext().getSession(false);
            Usuario logado
                    = (Usuario) sessao.getAttribute("usuarioLogado");
            conta.setUsuario(logado);

            System.out.println("ID -> " + this.conta.getId());
            if (this.conta.getId() == null) {
                repository.inserir(conta);
                Mensagem.show("Salvo com sucesso!");
            } else {
                repository.atualizar(conta.getId(), conta);
                Mensagem.show("Atualizado com sucesso!");
            }
            this.conta = new Conta();
            this.contas = repository.listar();
            return "contas";
        } catch (SQLException ex) {
            Mensagem.showError(ex.getMessage());
        }
        return null;
    }

    public String alterar() {
        return "contas_form";
    }

    public String excluir() {
        try {
            repository.excluir(conta.getId());
            this.contas.remove(conta);
            this.conta = new Conta();
            Mensagem.show("Conta Excluída com Sucesso");
        } catch (SQLException ex) {
            Mensagem.show(ex.getMessage());
        }
        return null;
    }


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
