package br.ufg.cs.controller;

import br.ufg.cs.model.Endereco;
import br.ufg.cs.util.Conexao;
import java.sql.SQLException;

/**
 * Classe responsável por conter os as funções referentes ao Endereço
 *
 * @author José Sérgio de Souza
 * @date 30/06/2016 08:51:43
 * @version 1.0
 */
public class CtrEndereco extends Conexao {

    private static CtrEndereco instance;

    /**
     *
     * Método responsável por criar uma instancia da classe
     *
     * @return
     * @author José Sérgio de Souza
     * @date 30/06/2016 08:51:43
     * @version 1.0
     */
    public static CtrEndereco getInstance() {
        if (instance == null) {
            instance = new CtrEndereco();
        }
        return instance;
    }

    /**
     *
     * Método responsável por inserir um endereço no banco de dados
     *
     * @param token
     * @param objEndereco
     * @return
     * @author José Sérgio de Souza
     * @throws java.sql.SQLException
     * @date 30/06/2016 08:51:43
     * @version 1.0
     */
    public boolean InsertEndereco(String token, Endereco objEndereco) throws SQLException {
        return true;
    }

    /**
     *
     * Método responsável por buscar um endereço no banco de dados
     *
     * @param token
     * @param idEndereco
     * @return
     * @author José Sérgio de Souza
     * @throws java.sql.SQLException
     * @date 30/06/2016 08:51:43
     * @version 1.0
     */
    public Endereco GetEndereco(String token, int idEndereco) throws SQLException {
        return null;
    }

    /**
     *
     * Método responsável por alterar um endereço no banco de dados
     *
     * @param token
     * @param objEndereco
     * @return
     * @author José Sérgio de Souza
     * @throws java.sql.SQLException
     * @date 30/06/2016 08:51:43
     * @version 1.0
     */
    public boolean UpdateEndereco(String token, Endereco objEndereco) throws SQLException {
        return true;
    }

    /**
     *
     * Método responsável por excluir um endereço no banco de dados
     *
     * @param token
     * @param idEndereco
     * @return
     * @author José Sérgio de Souza
     * @throws java.sql.SQLException
     * @date 30/06/2016 08:51:43
     * @version 1.0
     */
    public boolean DeleteEndereco(String token, Integer idEndereco) throws SQLException {
        return true;
    }
}
