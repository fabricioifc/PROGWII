package repository;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author fabricio
 */
public interface CRUD<T> {

    public void inserir(T objeto) throws SQLException;

    public void atualizar(int pk, T objeto) throws SQLException;

    public void excluir(int pk) throws SQLException;

    public List<T> listar() throws SQLException;

    public T getByPk(int pk) throws SQLException;
}
