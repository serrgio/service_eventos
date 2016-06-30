package br.ufg.cs.controller;

import br.ufg.cs.model.Usuario;
import br.ufg.cs.util.Conexao;
import java.sql.SQLException;

/**
 * Classe respons�vel por conter os as fun��es referentes a Thread
 *
 * @author Jos� S�rgio de Souza
 * @date 30/06/2016 08:51:43
 * @version 1.0
 */
public class CtrThread extends Conexao {

    private static CtrThread instance;

    /**
     *
     * M�todo respons�vel por criar uma instancia da classe
     *
     * @return
     * @author Jos� S�rgio de Souza
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
     * M�todo respons�vel por inserir uma thread no banco de dados
     *
     * @param objUsuario
     * @return
     * @author Jos� S�rgio de Souza
     * @throws java.sql.SQLException
     * @date 30/06/2016 08:51:43
     * @version 1.0
     */
    public String InsertThread(Usuario objUsuario) throws SQLException {
        return null;
    }

    /**
     *
     * M�todo respons�vel por buscar uma thread no banco de dados
     *
     * @param token
     * @return
     * @author Jos� S�rgio de Souza
     * @throws java.sql.SQLException
     * @date 30/06/2016 08:51:43
     * @version 1.0
     */
    public Usuario GetThread(String token) throws SQLException {
        return null;
    }

    /**
     *
     * M�todo respons�vel por alterar uma thread no banco de dados
     *
     * @param objUsuario
     * @return
     * @author Jos� S�rgio de Souza
     * @throws java.sql.SQLException
     * @date 30/06/2016 08:51:43
     * @version 1.0
     */
    public boolean UpdateThread(Usuario objUsuario) throws SQLException {
        return true;
    }
}
