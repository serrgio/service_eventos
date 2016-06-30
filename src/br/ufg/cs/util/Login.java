package br.ufg.cs.util;

import java.sql.SQLException;

/**
 * Classe responsável por conter os as funções de login
 *
 * @author José Sérgio de Souza
 * @date 30/06/2016 08:51:43
 * @version 1.0
 */
public class Login extends Conexao {

    private static Login instance;

    /**
     *
     * Método responsável por criar uma instancia da classe
     *
     * @return
     * @author José Sérgio de Souza
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
     * Método responsável por excluir uma categoria de eventos no banco de dados
     *
     * @param email
     * @param senha
     * @return
     * @author José Sérgio de Souza
     * @throws java.sql.SQLException
     * @date 30/06/2016 08:51:43
     * @version 1.0
     */
    public boolean Logar(String email, String senha) throws SQLException {
        return true;
    }
}
