package br.ufg.cs.controller;

import br.ufg.cs.model.Evento;
import br.ufg.cs.util.Conexao;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Classe respons�vel por conter os as fun��es referentes ao Evento
 *
 * @author Jos� S�rgio de Souza
 * @date 30/06/2016 08:51:43
 * @version 1.0
 */
public class CtrEvento extends Conexao {

    private static CtrEvento instance;

    /**
     *
     * M�todo respons�vel por criar uma instancia da classe
     *
     * @return
     * @author Jos� S�rgio de Souza
     * @date 30/06/2016 08:51:43
     * @version 1.0
     */
    public static CtrEvento getInstance() {
        if (instance == null) {
            instance = new CtrEvento();
        }
        return instance;
    }

    /**
     *
     * M�todo respons�vel por inserir um evento no banco de dados
     *
     * @param token
     * @param objEvento
     * @return
     * @author Jos� S�rgio de Souza
     * @throws java.sql.SQLException
     * @date 30/06/2016 08:51:43
     * @version 1.0
     */
    public boolean InsertEvento(String token, Evento objEvento) throws SQLException {
        return true;
    }

    /**
     *
     * M�todo respons�vel por buscar um evento no banco de dados
     *
     * @param token
     * @param idEvento
     * @return
     * @author Jos� S�rgio de Souza
     * @throws java.sql.SQLException
     * @date 30/06/2016 08:51:43
     * @version 1.0
     */
    public Evento GetEvento(String token, int idEvento) throws SQLException {
        return null;
    }
    
    /**
     *
     * M�todo respons�vel por buscar uma lista de eventos no banco de dados
     *
     * @param token
     * @param idCategoria
     * @return
     * @author Jos� S�rgio de Souza
     * @throws java.sql.SQLException
     * @date 30/06/2016 08:51:43
     * @version 1.0
     */
    public ArrayList<Evento> GetLstEvento(String token, int idCategoria) throws SQLException {
        return null;
    }

    /**
     *
     * M�todo respons�vel por alterar um evento no banco de dados
     *
     * @param token
     * @param objEvento
     * @return
     * @author Jos� S�rgio de Souza
     * @throws java.sql.SQLException
     * @date 30/06/2016 08:51:43
     * @version 1.0
     */
    public boolean UpdateEvento(String token, Evento objEvento) throws SQLException {
        return true;
    }

    /**
     *
     * M�todo respons�vel por deletar um evento no banco de dados
     *
     * @param token
     * @param idEvento
     * @return
     * @author Jos� S�rgio de Souza
     * @throws java.sql.SQLException
     * @date 30/06/2016 08:51:43
     * @version 1.0
     */
    public boolean DeleteEvento(String token, Integer idEvento) throws SQLException {
        return true;
    }
}
