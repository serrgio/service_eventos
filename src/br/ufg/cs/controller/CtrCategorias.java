package br.ufg.cs.controller;

import br.ufg.cs.model.Categorias;
import br.ufg.cs.util.Conexao;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Classe responsável por conter os as funções referentes as Categorias dos Eventos
 *
 * @author José Sérgio de Souza
 * @date 30/06/2016 08:51:43
 * @version 1.0
 */
public class CtrCategorias extends Conexao {

    private static CtrCategorias instance;

    /**
     *
     * Método responsável por criar uma instancia da classe
     *
     * @return
     * @author José Sérgio de Souza
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
     * Método responsável por inserir uma categoria de eventos no banco de dados
     *
     * @param token
     * @param objCategorias
     * @return
     * @author José Sérgio de Souza
     * @throws java.sql.SQLException
     * @date 30/06/2016 08:51:43
     * @version 1.0
     */
    public boolean InsertCategorias(String token, Categorias objCategorias) throws SQLException {
        return true;
    }

    /**
     *
     * Método responsável por buscar uma lista de categorias de eventos no banco de dados
     *
     * @param token
     * @return
     * @author José Sérgio de Souza
     * @throws java.sql.SQLException
     * @date 30/06/2016 08:51:43
     * @version 1.0
     */
    public ArrayList<Categorias> GetCategorias(String token) throws SQLException {
        return null;
    }

    /**
     *
     * Método responsável por alterar uma categoria de eventos no banco de dados
     *
     * @param token
     * @param objCategorias
     * @return
     * @author José Sérgio de Souza
     * @throws java.sql.SQLException
     * @date 30/06/2016 08:51:43
     * @version 1.0
     */
    public boolean UpdateCategorias(String token, Categorias objCategorias) throws SQLException {
        return true;
    }

    /**
     *
     * Método responsável por excluir uma categoria de eventos no banco de dados
     *
     * @param token
     * @param idCategorias
     * @return
     * @author José Sérgio de Souza
     * @throws java.sql.SQLException
     * @date 30/06/2016 08:51:43
     * @version 1.0
     */
    public boolean DeleteCategorias(String token, Integer idCategorias) throws SQLException {
        return true;
    }
}
