package repository;

import db.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author fabricio
 */
public class UsuarioRepository {

    public boolean validarUsuarioEmailSenha(String email, String senha) throws SQLException {
//        throw new UnsupportedOperationException("Implemente esse método");
        Connection conexao = null;
        String sql = "select * from usuarios where email = ? and senha = ?";

        try {
            conexao = Conexao.getConnection();
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, senha);

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

}
