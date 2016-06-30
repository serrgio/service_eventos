package br.ufg.cs.controller;

import br.ufg.cs.model.Fotos;
import br.ufg.cs.util.Conexao;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Classe responsável por conter os as funções referentes as Fotos dos Eventos
 *
 * @author José Sérgio de Souza
 * @date 30/06/2016 08:51:43
 * @version 1.0
 */
public class CtrFotos extends Conexao {

    private static CtrFotos instance;

    /**
     *
     * Método responsável por criar uma instancia da classe
     *
     * @return
     * @author José Sérgio de Souza
     * @date 30/06/2016 08:51:43
     * @version 1.0
     */
    public static CtrFotos getInstance() {
        if (instance == null) {
            instance = new CtrFotos();
        }
        return instance;
    }

    /**
     *
     * Método responsável por inserir uma foto no banco de dados
     *
     * @param token
     * @param objFotos
     * @return
     * @author José Sérgio de Souza
     * @throws java.sql.SQLException
     * @date 30/06/2016 08:51:43
     * @version 1.0
     */
    public boolean InsertFotos(String token, Fotos objFotos) throws SQLException {
        return true;
    }

    /**
     *
     * Método responsável por inserir uma foto no banco de dados
     *
     * @param token
     * @param idEvento
     * @return
     * @author José Sérgio de Souza
     * @throws java.sql.SQLException
     * @date 30/06/2016 08:51:43
     * @version 1.0
     */
    public ArrayList<Fotos> GetFotos(String token, int idEvento) throws SQLException {
        return null;
    }

    /**
     *
     * Método responsável por excluir uma foto no banco de dados
     *
     * @param token
     * @param idFotos
     * @return
     * @author José Sérgio de Souza
     * @throws java.sql.SQLException
     * @date 30/06/2016 08:51:43
     * @version 1.0
     */
    public boolean DeleteFotos(String token, Integer idFotos) throws SQLException {
        return true;
    }
}
