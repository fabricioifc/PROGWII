/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifc.controller;

import br.edu.ifc.dao.LancamentoDao;
import br.edu.ifc.dao.LancamentoDaoImpl;
import br.edu.ifc.model.Lancamento;
import br.edu.ifc.util.MensagemUtils;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author fabricio
 */
@ManagedBean
@ViewScoped
public class LancamentoBean implements Serializable {

    private Lancamento lancamento;
    private List<Lancamento> lista;
    private final LancamentoDao dao;

    public LancamentoBean() {
        lancamento = new Lancamento();
        dao = new LancamentoDaoImpl();
    }

    @PostConstruct
    public void init() {
        try {
            buscarTodos();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void prepararAlterar() throws Exception {
        try {
            this.lancamento = dao.buscarPorId(lancamento.getId());
        } catch (Exception ex) {
            MensagemUtils.adicionarMensagemDeErroPadrao(ex);
            throw ex;
        }
    }

    public void buscarTodos() throws Exception {
        try {
            lista = dao.buscarTodos();
        } catch (Exception ex) {
            MensagemUtils.adicionarMensagemDeErroPadrao(ex);
            throw ex;
        }

    }

    public void salvar() throws Exception {
        try {
            if (lancamento.getId() == null) {
                dao.inserir(lancamento);
            } else {
                dao.atualizar(lancamento);
            }
            limparCampos();
            buscarTodos();
            MensagemUtils.adicionarMensagemDeSucesso("Salvo/atualizado com sucesso!");
        } catch (Exception ex) {
            MensagemUtils.adicionarMensagemDeErroPadrao(ex);
            throw ex;
        }
    }

    public void remover() throws Exception {
        try {
            dao.remover(lancamento.getId());
            limparCampos();
            buscarTodos();
            MensagemUtils.adicionarMensagemDeSucesso("Excluído com sucesso!");
        } catch (Exception ex) {
            MensagemUtils.adicionarMensagemDeErroPadrao(ex);
            throw ex;
        }
    }

    public Lancamento buscarPorId(Integer id) throws Exception {
        try {
            return dao.buscarPorId(id);
        } catch (Exception ex) {
            MensagemUtils.adicionarMensagemDeErroPadrao(ex);
            throw ex;
        }
    }

    public void limparCampos() {
        try {
            this.lancamento = new Lancamento();
        } catch (Exception ex) {
            MensagemUtils.adicionarMensagemDeErroPadrao(ex);
            throw ex;
        }
    }

    public Lancamento getLancamento() {
        return lancamento;
    }

    public void setLancamento(Lancamento pizzaria) {
        this.lancamento = pizzaria;
    }

    public List<Lancamento> getLancamentos() {
        return lista;
    }

    public void setLancamentos(List<Lancamento> pizzarias) {
        this.lista = pizzarias;
    }
    
    public void formatarData() {
        System.out.println(this.lancamento.getDtlancamento());
        this.lancamento.setDescricao("teste");
    }

}
