package br.ufg.cs.controller;

import br.ufg.cs.model.Endereco;
import br.ufg.cs.util.Conexao;
import java.sql.SQLException;

/**
 * Classe respons�vel por conter os as fun��es referentes ao Endere�o
 *
 * @author Jos� S�rgio de Souza
 * @date 30/06/2016 08:51:43
 * @version 1.0
 */
public class CtrEndereco extends Conexao {

    private static CtrEndereco instance;

    /**
     *
     * M�todo respons�vel por criar uma instancia da classe
     *
     * @return
     * @author Jos� S�rgio de Souza
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
     * M�todo respons�vel por inserir um endere�o no banco de dados
     *
     * @param token
     * @param objEndereco
     * @return
     * @author Jos� S�rgio de Souza
     * @throws java.sql.SQLException
     * @date 30/06/2016 08:51:43
     * @version 1.0
     */
    public boolean InsertEndereco(String token, Endereco objEndereco) throws SQLException {
        return true;
    }

    /**
     *
     * M�todo respons�vel por buscar um endere�o no banco de dados
     *
     * @param token
     * @param idEndereco
     * @return
     * @author Jos� S�rgio de Souza
     * @throws java.sql.SQLException
     * @date 30/06/2016 08:51:43
     * @version 1.0
     */
    public Endereco GetEndereco(String token, int idEndereco) throws SQLException {
        return null;
    }

    /**
     *
     * M�todo respons�vel por alterar um endere�o no banco de dados
     *
     * @param token
     * @param objEndereco
     * @return
     * @author Jos� S�rgio de Souza
     * @throws java.sql.SQLException
     * @date 30/06/2016 08:51:43
     * @version 1.0
     */
    public boolean UpdateEndereco(String token, Endereco objEndereco) throws SQLException {
        return true;
    }

    /**
     *
     * M�todo respons�vel por excluir um endere�o no banco de dados
     *
     * @param token
     * @param idEndereco
     * @return
     * @author Jos� S�rgio de Souza
     * @throws java.sql.SQLException
     * @date 30/06/2016 08:51:43
     * @version 1.0
     */
    public boolean DeleteEndereco(String token, Integer idEndereco) throws SQLException {
        return true;
    }
}
