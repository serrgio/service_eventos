package br.ufg.cs.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by José Sergio on 16/06/2016.
 */
public class Conexao {

    public static Connection Conectar() {
        String dbURL = "jdbc:mysql://localhost:3306/evento";
        String username = "evento";
        String password = "123";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(dbURL, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
