package br.ufg.cs.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe respons�vel por conter os as fun��es referentes a conex�o com o banco de dados
 *
 * @author Jos� S�rgio de Souza
 * @date 30/06/2016 08:51:43
 * @version 1.0
 */
public class Conexao {

    private static Conexao instance;

    /**
     *
     * M�todo respons�vel por criar uma instancia da classe
     *
     * @return
     * @author Jos� S�rgio de Souza
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
     * M�todo respons�vel por conectar ao banco de dados
     *
     * @return
     * @author Jos� S�rgio de Souza
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
