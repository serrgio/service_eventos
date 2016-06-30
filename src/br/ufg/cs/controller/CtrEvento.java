package br.ufg.cs.controller;

import br.ufg.cs.model.Evento;
import br.ufg.cs.util.Conexao;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Classe responsável por conter os as funções referentes ao Evento
 *
 * @author José Sérgio de Souza
 * @date 30/06/2016 08:51:43
 * @version 1.0
 */
public class CtrEvento extends Conexao {

    private static CtrEvento instance;

    /**
     *
     * Método responsável por criar uma instancia da classe
     *
     * @return
     * @author José Sérgio de Souza
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
     * Método responsável por inserir um evento no banco de dados
     *
     * @param token
     * @param objEvento
     * @return
     * @author José Sérgio de Souza
     * @throws java.sql.SQLException
     * @date 30/06/2016 08:51:43
     * @version 1.0
     */
    public boolean InsertEvento(String token, Evento objEvento) throws SQLException {
        return true;
    }

    /**
     *
     * Método responsável por buscar um evento no banco de dados
     *
     * @param token
     * @param idEvento
     * @return
     * @author José Sérgio de Souza
     * @throws java.sql.SQLException
     * @date 30/06/2016 08:51:43
     * @version 1.0
     */
    public Evento GetEvento(String token, int idEvento) throws SQLException {
        return null;
    }
    
    /**
     *
     * Método responsável por buscar uma lista de eventos no banco de dados
     *
     * @param token
     * @param idCategoria
     * @return
     * @author José Sérgio de Souza
     * @throws java.sql.SQLException
     * @date 30/06/2016 08:51:43
     * @version 1.0
     */
    public ArrayList<Evento> GetLstEvento(String token, int idCategoria) throws SQLException {
        return null;
    }

    /**
     *
     * Método responsável por alterar um evento no banco de dados
     *
     * @param token
     * @param objEvento
     * @return
     * @author José Sérgio de Souza
     * @throws java.sql.SQLException
     * @date 30/06/2016 08:51:43
     * @version 1.0
     */
    public boolean UpdateEvento(String token, Evento objEvento) throws SQLException {
        return true;
    }

    /**
     *
     * Método responsável por deletar um evento no banco de dados
     *
     * @param token
     * @param idEvento
     * @return
     * @author José Sérgio de Souza
     * @throws java.sql.SQLException
     * @date 30/06/2016 08:51:43
     * @version 1.0
     */
    public boolean DeleteEvento(String token, Integer idEvento) throws SQLException {
        return true;
    }
}
