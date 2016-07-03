package br.ufg.cs.controller;

import br.ufg.cs.model.Categorias;
import br.ufg.cs.util.Conexao;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Classe respons�vel por conter os as fun��es referentes as Categorias dos Eventos
 *
 * @author Jos� S�rgio de Souza
 * @date 30/06/2016 08:51:43
 * @version 1.0
 */
public class CtrCategorias extends Conexao {

    private static CtrCategorias instance;

    /**
     *
     * M�todo respons�vel por criar uma instancia da classe
     *
     * @return
     * @author Jos� S�rgio de Souza
     * @date 30/06/2016 08:51:43
     * @version 1.0
     */
    public static CtrCategorias getInstance() {
        if (instance == null) {
            instance = new CtrCategorias();
        }
        return instance;
    }

    /**
     *
     * M�todo respons�vel por inserir uma categoria de eventos no banco de dados
     *
     * @param token
     * @param objCategorias
     * @return
     * @author Jos� S�rgio de Souza
     * @throws java.sql.SQLException
     * @date 30/06/2016 08:51:43
     * @version 1.0
     */
    public boolean InsertCategorias(String token, Categorias objCategorias) throws SQLException {
        return true;
    }

    /**
     *
     * M�todo respons�vel por buscar uma lista de categorias de eventos no banco de dados
     *
     * @param token
     * @return
     * @author Jos� S�rgio de Souza
     * @throws java.sql.SQLException
     * @date 30/06/2016 08:51:43
     * @version 1.0
     */
    public ArrayList<Categorias> GetCategorias(String token) throws SQLException {
        return null;
    }

    /**
     *
     * M�todo respons�vel por alterar uma categoria de eventos no banco de dados
     *
     * @param token
     * @param objCategorias
     * @return
     * @author Jos� S�rgio de Souza
     * @throws java.sql.SQLException
     * @date 30/06/2016 08:51:43
     * @version 1.0
     */
    public boolean UpdateCategorias(String token, Categorias objCategorias) throws SQLException {
        return true;
    }

    /**
     *
     * M�todo respons�vel por excluir uma categoria de eventos no banco de dados
     *
     * @param token
     * @param idCategorias
     * @return
     * @author Jos� S�rgio de Souza
     * @throws java.sql.SQLException
     * @date 30/06/2016 08:51:43
     * @version 1.0
     */
    public boolean DeleteCategorias(String token, Integer idCategorias) throws SQLException {
        return true;
    }
}
