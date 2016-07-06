package br.ufg.cs.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe respons�vel por conter os as fun��es referentes a conex�o com o banco
 * de dados
 *
 * @author Bianca Raissa
 * @author Jos� S�rgio
 * @author Rafhael Augusto
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
     * @author Bianca Raissa
     * @author Jos� S�rgio
     * @author Rafhael Augusto
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
     * @author Bianca Raissa
     * @author Jos� S�rgio
     * @author Rafhael Augusto
     * @date 30/06/2016 08:51:43
     * @version 1.0
     */
    public Connection Conectar() {
        String myDriver = "org.gjt.mm.mysql.Driver";
        String myUrl = "jdbc:mysql://localhost:3306/evento";
        try {
            Class.forName(myDriver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }

        Connection conn = null;
        try {
            conn = DriverManager.getConnection(myUrl, "root", "");
        } catch (SQLException e) {
            System.out.println(e);
        }
        return conn;
    }
}
