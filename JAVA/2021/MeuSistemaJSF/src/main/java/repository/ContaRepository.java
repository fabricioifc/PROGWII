package repository;

import db.Conexao;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import model.Conta;

/**
 *
 * @author fabricio
 */
public class ContaRepository implements CRUD<Conta> {

    @Override
    public void inserir(Conta objeto) throws SQLException {
        Connection conexao = null;
        String sql = "insert into contas "
                + "(titulo, saldo_inicial, usuario_id) "
                + "values (?,?,?) ";
        try {
            conexao = Conexao.getConnection();
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, objeto.getTitulo());
            ps.setDouble(2, objeto.getSaldoInicial());
            
            
            ps.setInt(3, objeto.getUsuario().getId());
            
            ps.execute();
        } catch (SQLException e) {
            throw e;
        } finally {
            conexao.close();
        }
    }

    @Override
    public void atualizar(int pk, Conta objeto) throws SQLException {
        Connection conexao = null;
        String sql = "update contas set titulo = ?, saldo_inicial = ?, usuario_id = ? "
                + "where id = ?";

        try {
            conexao = Conexao.getConnection();
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, objeto.getTitulo());
            ps.setDouble(2, objeto.getSaldoInicial());
            ps.setInt(3, objeto.getUsuario().getId());
                    
            ps.setInt(4, pk);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            conexao.close();
        }
    }

    @Override
    public void excluir(int pk) throws SQLException {
        Connection conexao = null;
        String sql = "delete from contas where id = ?";

        try {
            conexao = Conexao.getConnection();
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, pk);

            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            conexao.close();
        }
    }

    @Override
    public List<Conta> listar() throws SQLException {
        Connection conexao = null;
        List<Conta> contas = new ArrayList<>();
        String sql = "select * from contas order by titulo";

        try {
            conexao = Conexao.getConnection();
            PreparedStatement ps = conexao.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                contas.add(new Conta(rs.getInt("id"), rs.getString("titulo"), rs.getDouble("saldo_inicial")));
            }

            return contas;
        } catch (SQLException e) {
            throw e;
        } finally {
            conexao.close();
        }
    }

    @Override
    public Conta getByPk(int pk) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
