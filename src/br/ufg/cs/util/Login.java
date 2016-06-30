package br.ufg.cs.util;

import java.sql.SQLException;

/**
 * Classe respons�vel por conter os as fun��es de login
 *
 * @author Jos� S�rgio de Souza
 * @date 30/06/2016 08:51:43
 * @version 1.0
 */
public class Login extends Conexao {

    private static Login instance;

    /**
     *
     * M�todo respons�vel por criar uma instancia da classe
     *
     * @return
     * @author Jos� S�rgio de Souza
     * @date 30/06/2016 08:51:43
     * @version 1.0
     */
    public static Login getInstance() {
        if (instance == null) {
            instance = new Login();
        }
        return instance;
    }
    
    /**
     *
     * M�todo respons�vel por excluir uma categoria de eventos no banco de dados
     *
     * @param email
     * @param senha
     * @return
     * @author Jos� S�rgio de Souza
     * @throws java.sql.SQLException
     * @date 30/06/2016 08:51:43
     * @version 1.0
     */
    public boolean Logar(String email, String senha) throws SQLException {
        return true;
    }
}
