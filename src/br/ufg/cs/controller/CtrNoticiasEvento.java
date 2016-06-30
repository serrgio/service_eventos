package br.ufg.cs.controller;

import br.ufg.cs.model.NoticiasEvento;
import br.ufg.cs.util.Conexao;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Classe responsável por conter os as funções referentes a Noticias dos Eventos
 *
 * @author José Sérgio de Souza
 * @date 30/06/2016 08:51:43
 * @version 1.0
 */
public class CtrNoticiasEvento extends Conexao {

    private static CtrNoticiasEvento instance;

    /**
     *
     * Método responsável por criar uma instancia da classe
     *
     * @return
     * @author José Sérgio de Souza
     * @date 30/06/2016 08:51:43
     * @version 1.0
     */
    public static CtrNoticiasEvento getInstance() {
        if (instance == null) {
            instance = new CtrNoticiasEvento();
        }
        return instance;
    }

    /**
     *
     * Método responsável por inserir uma notícia no banco de dados
     *
     * @param token
     * @param objNoticiasEvento
     * @return
     * @author José Sérgio de Souza
     * @throws java.sql.SQLException
     * @date 30/06/2016 08:51:43
     * @version 1.0
     */
    public boolean InsertNoticiasEvento(String token, NoticiasEvento objNoticiasEvento) throws SQLException {
        return true;
    }

    /**
     *
     * Método responsável por buscar uma lista de notícia no banco de dados
     *
     * @param token
     * @param idEvento
     * @return
     * @author José Sérgio de Souza
     * @throws java.sql.SQLException
     * @date 30/06/2016 08:51:43
     * @version 1.0
     */
    public ArrayList<NoticiasEvento> GetNoticiasEvento(String token, int idEvento) throws SQLException {
        return null;
    }

    /**
     *
     * Método responsável por alterar uma notícia no banco de dados
     *
     * @param token
     * @param objNoticiasEvento
     * @return
     * @author José Sérgio de Souza
     * @throws java.sql.SQLException
     * @date 30/06/2016 08:51:43
     * @version 1.0
     */
    public boolean UpdateNoticiasEvento(String token, NoticiasEvento objNoticiasEvento) throws SQLException {
        return true;
    }

    /**
     *
     * Método responsável por exxcluir uma notícia no banco de dados
     *
     * @param token
     * @param idNoticiasEvento
     * @return
     * @author José Sérgio de Souza
     * @throws java.sql.SQLException
     * @date 30/06/2016 08:51:43
     * @version 1.0
     */
    public boolean DeleteNoticiasEvento(String token, Integer idNoticiasEvento) throws SQLException {
        return true;
    }
}
