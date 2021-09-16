/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifc.dao;

import br.edu.ifc.model.Lancamento;
import br.edu.ifc.util.ConnectionProvider;
import br.edu.ifc.util.Transacao;
import br.edu.ifc.util.TransacaoJdbcImpl;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author fabricio
 */
public class LancamentoDaoImpl implements LancamentoDao, Serializable {

    @Override
    public void inserir(Lancamento objeto) throws Exception {
        Transacao tx = TransacaoJdbcImpl.getInstance();
        Connection conn = tx.getConnection();

        try {
            tx.begin();

            String query = "insert into Lancamentos (dtlancamento, descricao, tipo, valor) values (?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setDate(1, new java.sql.Date(objeto.getDtlancamento().getTime()));
            statement.setString(2, objeto.getDescricao());
            statement.setString(3, objeto.getTipo());
            statement.setDouble(4, objeto.getValor());

            statement.executeUpdate();

            tx.commit();
        } catch (SQLException sqlException) {
            throw new Exception(sqlException);
        }
    }

    @Override
    public void remover(Integer objeto) throws Exception {
        Transacao tx = TransacaoJdbcImpl.getInstance();
        Connection conn = tx.getConnection();

        try {
            tx.begin();

            String query = "delete from Lancamentos where id = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setLong(1, objeto);

            statement.executeUpdate();

            tx.commit();

        } catch (SQLException sqlException) {
            throw new Exception(sqlException);
        } finally {
            try {
                conn.close();
            } catch (SQLException sqlException) {
                throw new Exception(sqlException);
            }
        }
    }

    @Override
    public void atualizar(Lancamento objeto) throws Exception {
        Transacao tx = TransacaoJdbcImpl.getInstance();
        Connection conn = tx.getConnection();

        try {
            tx.begin();

            String query = "update Lancamentos set dtlancamento = ?, "
                    + "descricao = ?, tipo = ?, valor = ? "
                    + "where id = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setDate(1, new java.sql.Date(objeto.getDtlancamento().getTime()));
            statement.setString(2, objeto.getDescricao());
            statement.setString(3, objeto.getTipo());
            statement.setDouble(4, objeto.getValor());

            statement.setLong(5, objeto.getId());
            statement.executeUpdate();

            tx.commit();

        } catch (SQLException sqlException) {
            throw new Exception(sqlException);
        } finally {
            try {
                conn.close();
            } catch (SQLException sqlException) {
                throw new Exception(sqlException);
            }
        }
    }

    @Override
    public Lancamento buscarPorId(Integer id) throws Exception {
        Lancamento lancamento = new Lancamento();
        try {
            String query = "select * from Lancamentos where id = ?";
            PreparedStatement statement = ConnectionProvider.getInstance().getConnection().prepareStatement(query);
            statement.setLong(1, id);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                lancamento = new Lancamento();
                lancamento.setId(resultSet.getInt("id"));
                lancamento.setDtlancamento(resultSet.getDate("dtlancamento"));
                lancamento.setDescricao(resultSet.getString("descricao"));
                lancamento.setTipo(resultSet.getString("tipo"));
                lancamento.setValor(resultSet.getDouble("valor"));
            }
        } catch (SQLException sqlException) {
            throw new Exception(sqlException);
        }
        return lancamento;
    }

    @Override
    public List<Lancamento> buscarTodos() throws Exception {
        List<Lancamento> lista = new LinkedList<>();
        Lancamento lancamento = new Lancamento();
        try {
            String query = "select * from Lancamentos";
            PreparedStatement statement = ConnectionProvider.getInstance()
                    .getConnection().prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                lancamento = new Lancamento();
                lancamento.setId(resultSet.getInt("id"));
                lancamento.setDtlancamento(resultSet.getDate("dtlancamento"));
                lancamento.setDescricao(resultSet.getString("descricao"));
                lancamento.setTipo(resultSet.getString("tipo"));
                lancamento.setValor(resultSet.getDouble("valor"));
                lista.add(lancamento);
            }
        } catch (SQLException sqlException) {
            throw new Exception(sqlException);
        }
        return lista;
    }
}
