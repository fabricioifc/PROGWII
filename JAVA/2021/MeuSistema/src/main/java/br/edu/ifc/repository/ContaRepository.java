package br.edu.ifc.repository;

import br.edu.ifc.db.Conexao;
import br.edu.ifc.model.Conta;
import br.edu.ifc.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
        String sql = "select * from contas order by titulo asc";

        List<Conta> lista = new ArrayList<>();

        try {
            conexao = Conexao.getConnection();
            PreparedStatement ps = conexao.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("titulo"));
                Conta conta = new Conta(rs.getInt("id"), rs.getString("titulo"), rs.getDouble("saldo_inicial"));
                lista.add(conta);
            }

            return lista;
        } catch (SQLException e) {
            throw e;
        } finally {
            if (conexao != null) {
                conexao.close();
            }
        }
    }

    @Override
    public Conta getByPk(int pk) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
