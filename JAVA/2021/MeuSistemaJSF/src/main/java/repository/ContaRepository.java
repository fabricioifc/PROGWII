package repository;

import db.Conexao;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Conta;

/**
 *
 * @author fabricio
 */
public class ContaRepository implements CRUD<Conta> {

    @Override
    public void inserir(Conta objeto) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void atualizar(int pk, Conta objeto) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir(int pk) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
            if (rs.next()) {
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
