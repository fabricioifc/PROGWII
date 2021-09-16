/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifc.dao;

import br.edu.ifc.model.Lancamento;

/**
 *
 * @author fabricio
 */
public interface LancamentoDao {

    public void inserir(Lancamento objeto) throws Exception;

    public void remover(Integer objeto) throws Exception;

    public void atualizar(Lancamento objeto) throws Exception;

    public Lancamento buscarPorId(Integer id) throws Exception;

    public java.util.List<Lancamento> buscarTodos() throws Exception;
}
