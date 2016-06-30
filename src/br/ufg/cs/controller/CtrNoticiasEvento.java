package br.ufg.cs.controller;

import br.ufg.cs.model.NoticiasEvento;
import br.ufg.cs.util.Conexao;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Classe respons�vel por conter os as fun��es referentes a Noticias dos Eventos
 *
 * @author Jos� S�rgio de Souza
 * @date 30/06/2016 08:51:43
 * @version 1.0
 */
public class CtrNoticiasEvento extends Conexao {

    private static CtrNoticiasEvento instance;

    /**
     *
     * M�todo respons�vel por criar uma instancia da classe
     *
     * @return
     * @author Jos� S�rgio de Souza
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
     * M�todo respons�vel por inserir uma not�cia no banco de dados
     *
     * @param token
     * @param objNoticiasEvento
     * @return
     * @author Jos� S�rgio de Souza
     * @throws java.sql.SQLException
     * @date 30/06/2016 08:51:43
     * @version 1.0
     */
    public boolean InsertNoticiasEvento(String token, NoticiasEvento objNoticiasEvento) throws SQLException {
        return true;
    }

    /**
     *
     * M�todo respons�vel por buscar uma lista de not�cia no banco de dados
     *
     * @param token
     * @param idEvento
     * @return
     * @author Jos� S�rgio de Souza
     * @throws java.sql.SQLException
     * @date 30/06/2016 08:51:43
     * @version 1.0
     */
    public ArrayList<NoticiasEvento> GetNoticiasEvento(String token, int idEvento) throws SQLException {
        return null;
    }

    /**
     *
     * M�todo respons�vel por alterar uma not�cia no banco de dados
     *
     * @param token
     * @param objNoticiasEvento
     * @return
     * @author Jos� S�rgio de Souza
     * @throws java.sql.SQLException
     * @date 30/06/2016 08:51:43
     * @version 1.0
     */
    public boolean UpdateNoticiasEvento(String token, NoticiasEvento objNoticiasEvento) throws SQLException {
        return true;
    }

    /**
     *
     * M�todo respons�vel por exxcluir uma not�cia no banco de dados
     *
     * @param token
     * @param idNoticiasEvento
     * @return
     * @author Jos� S�rgio de Souza
     * @throws java.sql.SQLException
     * @date 30/06/2016 08:51:43
     * @version 1.0
     */
    public boolean DeleteNoticiasEvento(String token, Integer idNoticiasEvento) throws SQLException {
        return true;
    }
}
