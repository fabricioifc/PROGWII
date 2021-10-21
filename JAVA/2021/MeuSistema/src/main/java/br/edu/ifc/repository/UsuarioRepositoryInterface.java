/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifc.repository;

import br.edu.ifc.model.Usuario;
import java.sql.SQLException;

/**
 *
 * @author fabricio
 */
public interface UsuarioRepositoryInterface {

    public boolean validarUsuarioEmailSenha(Usuario u) throws SQLException;
}
