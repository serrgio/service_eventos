package br.ufg.cs.controller;

import br.ufg.cs.model.Categorias;
import br.ufg.cs.model.NoticiasEvento;
import br.ufg.cs.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
     * @param objNoticiasEvento
     * @return
     * @author Jos� S�rgio de Souza
     * @throws java.sql.SQLException
     * @date 30/06/2016 08:51:43
     * @version 1.0
     */
    public boolean InsertNoticiasEvento(NoticiasEvento objNoticiasEvento) throws SQLException {
        boolean bRetorno = false;
        try (Connection conn = Conexao.getInstance().Conectar()) {
            String sql = "INSERT INTO noticiasevento(idEvento, idUsuario, dtCadastro, titulo, descricao) VALUES (?,?,NOW(),?,?)";
            PreparedStatement statement = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, objNoticiasEvento.getIdEvento());
            statement.setInt(2, objNoticiasEvento.getIdUsuario());
            statement.setString(3, objNoticiasEvento.getsTitulo());
            statement.setString(4, objNoticiasEvento.getsDescricao());
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                bRetorno = true;
            }
        }
        return bRetorno;
    }

    /**
     *
     * M�todo respons�vel por buscar uma lista de not�cia no banco de dados
     *
     * @param idEvento
     * @return
     * @author Jos� S�rgio de Souza
     * @throws java.sql.SQLException
     * @date 30/06/2016 08:51:43
     * @version 1.0
     */
    public ArrayList<NoticiasEvento> GetNoticiasEvento(int idEvento) throws SQLException {
        ArrayList<NoticiasEvento> lstNoticiasEvento = new ArrayList<>();
        try (Connection conn = Conexao.getInstance().Conectar()) {
            String sql = "SELECT id, idEvento, idUsuario, tCadastro, titulo, descricao FROM noticiasevento WHERE idEvento="+idEvento;

            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
                NoticiasEvento objNoticiasEvento = new NoticiasEvento();                
                objNoticiasEvento.setIdEvento(result.getInt(1));
                objNoticiasEvento.setIdEvento(result.getInt(2));
                objNoticiasEvento.setIdUsuario(result.getInt(3));
                objNoticiasEvento.setDtCadastro(result.getDate(4));
                objNoticiasEvento.setsTitulo(result.getString(5));
                objNoticiasEvento.setsDescricao(result.getString(6));
                lstNoticiasEvento.add(objNoticiasEvento);
            }
        }
        return lstNoticiasEvento;
    }

    /**
     *
     * M�todo respons�vel por alterar uma not�cia no banco de dados
     *
     * @param objNoticiasEvento
     * @return
     * @author Jos� S�rgio de Souza
     * @throws java.sql.SQLException
     * @date 30/06/2016 08:51:43
     * @version 1.0
     */
    public boolean UpdateNoticiasEvento(NoticiasEvento objNoticiasEvento) throws SQLException {
       boolean bRetorno = false;

        try (Connection conn = Conexao.getInstance().Conectar()) {
            String sql = "UPDATE noticiasevento SET titulo=?,descricao=? WHERE id=?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, objNoticiasEvento.getsTitulo());
            statement.setString(2, objNoticiasEvento.getsDescricao());
            statement.setInt(3, objNoticiasEvento.getId());

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                bRetorno = true;
            }
        }
        return bRetorno;
    }

    /**
     *
     * M�todo respons�vel por exxcluir uma not�cia no banco de dados
     *
     * @param idNoticiasEvento
     * @return
     * @author Jos� S�rgio de Souza
     * @throws java.sql.SQLException
     * @date 30/06/2016 08:51:43
     * @version 1.0
     */
    public boolean DeleteNoticiasEvento(Integer idNoticiasEvento) throws SQLException {
        boolean bRetorno = false;
        try (Connection conn = Conexao.getInstance().Conectar()) {
            String sql = "DELETE FROM noticiasevento WHERE id=?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setLong(1, idNoticiasEvento);

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                bRetorno = true;
            }
        }
        return bRetorno;
    }
}
