package br.ufg.cs.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe responsável por conter os as funções referentes a conexão com o banco de dados
 *
 * @author José Sérgio de Souza
 * @date 30/06/2016 08:51:43
 * @version 1.0
 */
public class Conexao {

    private static Conexao instance;

    /**
     *
     * Método responsável por criar uma instancia da classe
     *
     * @return
     * @author José Sérgio de Souza
     * @date 30/06/2016 08:51:43
     * @version 1.0
     */
    public static Conexao getInstance() {
        if (instance == null) {
            instance = new Conexao();
        }
        return instance;
    }

    /**
     *
     * Método responsável por conectar ao banco de dados
     *
     * @return
     * @author José Sérgio de Souza
     * @date 30/06/2016 08:51:43
     * @version 1.0
     */
    public Connection Conectar() {
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
