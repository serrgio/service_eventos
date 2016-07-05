package br.ufg.cs.controller;

import br.ufg.cs.model.Categorias;
import br.ufg.cs.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
     * @param objCategorias
     * @return
     * @author Jos� S�rgio de Souza
     * @throws java.sql.SQLException
     * @date 30/06/2016 08:51:43
     * @version 1.0
     */
    public boolean InsertCategorias(Categorias objCategorias) throws SQLException {
        boolean bRetorno = false;
        try (Connection conn = Conectar()) {
            String sql = "INSERT INTO categorias (nome, descricao, dtCadastro) VALUES (?,?,NOW())";
            PreparedStatement statement = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, objCategorias.getNome());
            statement.setString(2, objCategorias.getDescricao());
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                bRetorno = true;
            }
        }
        return bRetorno;
    }

    /**
     *
     * M�todo respons�vel por buscar uma lista de categorias de eventos no banco de dados
     *
     * @return
     * @author Jos� S�rgio de Souza
     * @throws java.sql.SQLException
     * @date 30/06/2016 08:51:43
     * @version 1.0
     */
    public ArrayList<Categorias> GetCategorias() throws SQLException {
        ArrayList<Categorias> lstUsuario = new ArrayList<>();
        try (Connection conn = Conectar()) {
            String sql = "SELECT id,nome,descricao,dtcadastro FROM categorias";

            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
                Categorias objCategorias = new Categorias();
                objCategorias.setId(result.getInt(1));
                objCategorias.setNome(result.getString(2));
                objCategorias.setDescricao(result.getString(3));
                objCategorias.setDtCadastro(result.getDate(4));
                lstUsuario.add(objCategorias);
            }
        }
        return lstUsuario;
    }

    /**
     *
     * M�todo respons�vel por alterar uma categoria de eventos no banco de dados
     *
     * @param objCategorias
     * @return
     * @author Jos� S�rgio de Souza
     * @throws java.sql.SQLException
     * @date 30/06/2016 08:51:43
     * @version 1.0
     */
    public boolean UpdateCategorias(Categorias objCategorias) throws SQLException {
        boolean bRetorno = false;

        try (Connection conn = Conectar()) {
            String sql = "UPDATE categorias SET nome=?, descricao=? WHERE id=?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, objCategorias.getNome());
            statement.setString(2, objCategorias.getDescricao());
            statement.setInt(3, objCategorias.getId());

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                bRetorno = true;
            }
        }
        return bRetorno;
    }

    /**
     *
     * M�todo respons�vel por excluir uma categoria de eventos no banco de dados
     *
     * @param idCategorias
     * @return
     * @author Jos� S�rgio de Souza
     * @throws java.sql.SQLException
     * @date 30/06/2016 08:51:43
     * @version 1.0
     */
    public boolean DeleteCategorias(Integer idCategorias) throws SQLException {
        boolean bRetorno = false;
        try (Connection conn = Conectar()) {
            String sql = "DELETE FROM Usuario WHERE id=?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setLong(1, idCategorias);

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                bRetorno = true;
            }
        }
        return bRetorno;
    }
}
