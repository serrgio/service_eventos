package br.ufg.cs.controller;

import br.ufg.cs.model.Endereco;
import br.ufg.cs.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Classe responsável por conter os as funções referentes ao Endereço
 *
 * @author Bianca Raissa
 * @author José Sérgio
 * @author Rafhael Augusto
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
     * @author Bianca Raissa
     * @author José Sérgio
     * @author Rafhael Augusto
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
     * @param objEndereco
     * @return
     * @author Bianca Raissa
     * @author José Sérgio
     * @author Rafhael Augusto
     * @throws java.sql.SQLException
     * @date 30/06/2016 08:51:43
     * @version 1.0
     */
    public Integer InsertEndereco(Endereco objEndereco) throws SQLException {
        Integer rowsInserted = 0;
        try (Connection conn = Conexao.getInstance().Conectar()) {
            String sql = "INSERT INTO endereco(cep, logradouro, complemento, bairro, localidade, uf) VALUES (?,?,?,?,?,?)";
            PreparedStatement statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, objEndereco.getCep());
            statement.setString(2, objEndereco.getLogradouro());
            statement.setString(3, objEndereco.getComplemento());
            statement.setString(4, objEndereco.getBairro());
            statement.setString(5, objEndereco.getLocalidade());
            statement.setString(6, objEndereco.getUf());
            statement.executeUpdate();
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                rowsInserted = generatedKeys.getInt(1);
            }
        }
        return rowsInserted;
    }

    /**
     *
     * Método responsável por buscar um endereço no banco de dados
     *
     * @param idEndereco
     * @return
     * @author Bianca Raissa
     * @author José Sérgio
     * @author Rafhael Augusto
     * @throws java.sql.SQLException
     * @date 30/06/2016 08:51:43
     * @version 1.0
     */
    public Endereco GetEndereco(int idEndereco) throws SQLException {
        Endereco objEndereco = new Endereco();
        try (Connection conn = Conexao.getInstance().Conectar()) {
            String sql = "SELECT cep, logradouro, complemento, bairro, localidade, uf, ibge FROM endereco WHERE id=" + idEndereco;

            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);

            if (result.next()) {
                objEndereco.setCep(result.getString(1));
                objEndereco.setLogradouro(result.getString(2));
                objEndereco.setComplemento(result.getString(3));
                objEndereco.setBairro(result.getString(4));
                objEndereco.setLocalidade(result.getString(5));
                objEndereco.setUf(result.getString(6));
                objEndereco.setIbge(result.getInt(7));
            }
        }
        return objEndereco;
    }

    /**
     *
     * Método responsável por alterar um endereço no banco de dados
     *
     * @param objEndereco
     * @return
     * @author Bianca Raissa
     * @author José Sérgio
     * @author Rafhael Augusto
     * @throws java.sql.SQLException
     * @date 30/06/2016 08:51:43
     * @version 1.0
     */
    public boolean UpdateEndereco(Endereco objEndereco) throws SQLException {
        boolean bRetorno = false;

        try (Connection conn = Conexao.getInstance().Conectar()) {
            String sql = "UPDATE endereco SET cep=?,logradouro=?,complemento=?,bairro=?,localidade=?,uf=?,ibge=? WHERE id=?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, objEndereco.getCep());
            statement.setString(2, objEndereco.getLogradouro());
            statement.setString(3, objEndereco.getComplemento());
            statement.setString(4, objEndereco.getBairro());
            statement.setString(5, objEndereco.getLocalidade());
            statement.setString(6, objEndereco.getUf());
            statement.setInt(7, objEndereco.getIbge());
            statement.setInt(8, objEndereco.getId());

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                bRetorno = true;
            }
        }
        return bRetorno;
    }

    /**
     *
     * Método responsável por excluir um endereço no banco de dados
     *
     * @param idEndereco
     * @return
     * @author Bianca Raissa
     * @author José Sérgio
     * @author Rafhael Augusto
     * @throws java.sql.SQLException
     * @date 30/06/2016 08:51:43
     * @version 1.0
     */
    public boolean DeleteEndereco(Integer idEndereco) throws SQLException {
        boolean bRetorno = false;
        try (Connection conn = Conexao.getInstance().Conectar()) {
            String sql = "DELETE FROM endereco WHERE id=?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setLong(1, idEndereco);

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                bRetorno = true;
            }
        }
        return bRetorno;
    }
}
