package br.edu.ifc.repository;

import br.edu.ifc.db.Conexao;
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
public class UsuarioRepository implements CRUD<Usuario>, UsuarioRepositoryInterface {

    @Override
    public void inserir(Usuario objeto) throws SQLException {
        Connection conexao = null;
        String sql = "INSERT INTO usuarios (email, senha) values (?,?)";

        try {
            conexao = Conexao.getConnection();
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, objeto.getEmail());
            ps.setString(2, objeto.getSenha());

            ps.execute();
        } catch (SQLException e) {
            throw e;
        } finally {
            conexao.close();
        }
    }

    @Override
    public void atualizar(int pk, Usuario objeto) throws SQLException {
        throw new UnsupportedOperationException("Implemente esse método");
    }

    @Override
    public void excluir(int pk) throws SQLException {
        throw new UnsupportedOperationException("Implemente esse método");
    }

    @Override
    public List<Usuario> listar() throws SQLException {
        Connection conexao = null;
        String sql = "select * from usuarios order by id asc";

        List<Usuario> lista = new ArrayList<>();

        try {
            conexao = Conexao.getConnection();
            PreparedStatement ps = conexao.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Usuario u = new Usuario(rs.getString("email"), rs.getString("senha"));
                lista.add(u);
            }

            return lista;
        } catch (SQLException e) {
            throw e;
        } finally {
            conexao.close();
        }
    }

    @Override
    public Usuario getByPk(int pk) throws SQLException {
        throw new UnsupportedOperationException("Implemente esse método");
    }

    @Override
    public boolean validarUsuarioEmailSenha(Usuario u) throws SQLException {
//        throw new UnsupportedOperationException("Implemente esse método");
        Connection conexao = null;
        String sql = "select * from usuarios where email = ? and senha = ?";

        try {
            conexao = Conexao.getConnection();
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, u.getEmail());
            ps.setString(2, u.getSenha());

            System.out.println(u);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }

            return false;
        } catch (SQLException e) {
            throw e;
        } finally {
            conexao.close();
        }

    }

//    public static void main(String[] args) {
//        try {
//            UsuarioRepository r = new UsuarioRepository();
//            Usuario u = new Usuario("teste3@teste.com", "123456");
//            r.inserir(u);
//
//            System.out.println(Arrays.asList(r.listar()));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}
