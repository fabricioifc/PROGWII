/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author fabricio
 */
public class ConnectionProvider {

    private static ConnectionProvider instance;
    private static Connection connection = null;

    private String url = "jdbc:derby://localhost:1527/ifc";

    private ConnectionProvider() throws Exception {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            connection = DriverManager.getConnection(this.url, "ifc", "ifc");
            connection.setAutoCommit(false);
        } catch (Exception classNotFoundException) {
            throw new Exception(classNotFoundException);
        }
    }

    public static ConnectionProvider getInstance() throws Exception {
        if (instance == null || connection == null  || connection.isClosed()) {
            instance = new ConnectionProvider();
        }
        return instance;
    }

    public Connection getConnection() throws Exception {

        try {
//            this.closeConnection();
//            connection = DriverManager.getConnection(this.url, "root", "root");
//            connection.setAutoCommit(false);
        } catch (Exception exception) {
            throw new Exception(exception);
        }
        return connection;
    }

    public void closeConnection() throws Exception {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException sqlException) {
                throw new Exception(sqlException);
            }
        }
    }

    public void rollback() throws Exception {
        if (connection != null) {
            try {
                connection.rollback();
            } catch (SQLException sqlException) {
                throw new Exception(sqlException);
            }
        }
    }
}
