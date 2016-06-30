package br.ufg.cs.controller;

import br.ufg.cs.model.Usuario;
import br.ufg.cs.util.Conexao;
import java.sql.SQLException;

/**
 * Classe responsável por conter os as funções referentes a Thread
 *
 * @author José Sérgio de Souza
 * @date 30/06/2016 08:51:43
 * @version 1.0
 */
public class CtrThread extends Conexao {

    private static CtrThread instance;

    /**
     *
     * Método responsável por criar uma instancia da classe
     *
     * @return
     * @author José Sérgio de Souza
     * @date 30/06/2016 08:51:43
     * @version 1.0
     */
    public static CtrThread getInstance() {
        if (instance == null) {
            instance = new CtrThread();
        }
        return instance;
    }

    /**
     *
     * Método responsável por inserir uma thread no banco de dados
     *
     * @param objUsuario
     * @return
     * @author José Sérgio de Souza
     * @throws java.sql.SQLException
     * @date 30/06/2016 08:51:43
     * @version 1.0
     */
    public String InsertThread(Usuario objUsuario) throws SQLException {
        return null;
    }

    /**
     *
     * Método responsável por buscar uma thread no banco de dados
     *
     * @param token
     * @return
     * @author José Sérgio de Souza
     * @throws java.sql.SQLException
     * @date 30/06/2016 08:51:43
     * @version 1.0
     */
    public Usuario GetThread(String token) throws SQLException {
        return null;
    }

    /**
     *
     * Método responsável por alterar uma thread no banco de dados
     *
     * @param objUsuario
     * @return
     * @author José Sérgio de Souza
     * @throws java.sql.SQLException
     * @date 30/06/2016 08:51:43
     * @version 1.0
     */
    public boolean UpdateThread(Usuario objUsuario) throws SQLException {
        return true;
    }
}
