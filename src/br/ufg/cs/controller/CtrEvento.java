package br.ufg.cs.controller;

import br.ufg.cs.model.Evento;
import br.ufg.cs.util.Conexao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Classe responsável por conter os as funções referentes ao Evento
 *
 * @author Bianca Raissa
 * @author José Sérgio
 * @author Rafhael Augusto
 * @date 30/06/2016 08:51:43
 * @version 1.0
 */
public class CtrEvento extends Conexao {

    private static CtrEvento instance;

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
    public static CtrEvento getInstance() {
        if (instance == null) {
            instance = new CtrEvento();
        }
        return instance;
    }

    /**
     *
     * Método responsável por inserir um evento no banco de dados
     *
     * @param objEvento
     * @return
     * @author Bianca Raissa
     * @author José Sérgio
     * @author Rafhael Augusto
     * @throws java.sql.SQLException
     * @date 30/06/2016 08:51:43
     * @version 1.0
     */
    public Integer InsertEvento(Evento objEvento) throws SQLException {
        Integer rowsInserted = 0;
        try (Connection conn = Conexao.getInstance().Conectar()) {
            String sql = "INSERT INTO evento(idCategoria, idUsuario, nome, descricao, idEndereco, dtEvento) VALUES (?,?,?,?,?,?)";
            PreparedStatement statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, objEvento.getIdCategoria());
            statement.setInt(2, objEvento.getIdUsuario());
            statement.setString(3, objEvento.getNome());
            statement.setString(4, objEvento.getDescricao());
            statement.setInt(5, CtrEndereco.getInstance().InsertEndereco(objEvento.getEndereco()));
            statement.setDate(6, (Date) objEvento.getDtEvento());
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                rowsInserted = generatedKeys.getInt(1);
            }
        }
        objEvento.getFoto().setIdEvento(rowsInserted);
        CtrFotos.getInstance().InsertFotos(objEvento.getFoto());
        return rowsInserted;
    }

    /**
     *
     * Método responsável por buscar um evento no banco de dados
     *
     * @param idEvento
     * @return
     * @author Bianca Raissa
     * @author José Sérgio
     * @author Rafhael Augusto
     * @throws java.sql.SQLException
     * @date 30/06/2016 08:51:43
     * @version 1.0
     */
    public Evento GetEvento(int idEvento) throws SQLException {
        Evento objEvento = new Evento();
        try (Connection conn = Conexao.getInstance().Conectar()) {
            String sql = "SELECT id, idCategoria, idUsuario, nome, descricao, idEndereco, dtEvento FROM evento WHERE id=" + idEvento;

            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);

            if (result.next()) {
                objEvento.setId(result.getInt(1));
                objEvento.setIdCategoria(result.getInt(2));
                objEvento.setIdUsuario(result.getInt(3));
                objEvento.setNome(result.getString(4));
                objEvento.setDescricao(result.getString(5));
                objEvento.setEndereco(CtrEndereco.getInstance().GetEndereco(result.getInt(6)));
                objEvento.setDtEvento(result.getDate(7));
                objEvento.setFoto(CtrFotos.getInstance().GetFotos(objEvento.getId()));
            }
        }
        return objEvento;
    }

    /**
     *
     * Método responsável por buscar uma lista de eventos no banco de dados
     *
     * @return
     * @author Bianca Raissa
     * @author José Sérgio
     * @author Rafhael Augusto
     * @throws java.sql.SQLException
     * @date 30/06/2016 08:51:43
     * @version 1.0
     */
    public ArrayList<Evento> GetLstEvento() throws SQLException {
        ArrayList<Evento> lstEvento = new ArrayList<>();
        try (Connection conn = Conexao.getInstance().Conectar()) {
            String sql = "SELECT id, idCategoria, idUsuario, nome, descricao, idEndereco, dtEvento FROM evento";

            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
                Evento objEvento = new Evento();
                objEvento.setId(result.getInt(1));
                objEvento.setIdCategoria(result.getInt(2));
                objEvento.setIdUsuario(result.getInt(3));
                objEvento.setNome(result.getString(4));
                objEvento.setDescricao(result.getString(5));
                objEvento.setEndereco(CtrEndereco.getInstance().GetEndereco(result.getInt(6)));
                objEvento.setDtEvento(result.getDate(7));
                objEvento.setFoto(CtrFotos.getInstance().GetFotos(objEvento.getId()));
                
                lstEvento.add(objEvento);
            }
        }
        return lstEvento;
    }

    /**
     *
     * Método responsável por alterar um evento no banco de dados
     *
     * @param objEvento
     * @return
     * @author Bianca Raissa
     * @author José Sérgio
     * @author Rafhael Augusto
     * @throws java.sql.SQLException
     * @date 30/06/2016 08:51:43
     * @version 1.0
     */
    public boolean UpdateEvento(Evento objEvento) throws SQLException {
        boolean bRetorno = false;

        try (Connection conn = Conexao.getInstance().Conectar()) {
            String sql = "UPDATE evento SET nome=?,descricao=?,dtEvento=? WHERE id=?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, objEvento.getNome());
            statement.setString(2, objEvento.getDescricao());
            statement.setDate(3, (Date) objEvento.getDtEvento());
            statement.setInt(4, objEvento.getId());

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                bRetorno = true;
            }
        }
        return bRetorno;
    }

    /**
     *
     * Método responsável por deletar um evento no banco de dados
     *
     * @param idEvento
     * @return
     * @author Bianca Raissa
     * @author José Sérgio
     * @author Rafhael Augusto
     * @throws java.sql.SQLException
     * @date 30/06/2016 08:51:43
     * @version 1.0
     */
    public boolean DeleteEvento(Integer idEvento) throws SQLException {
        boolean bRetorno = false;
        try (Connection conn = Conexao.getInstance().Conectar()) {
            String sql = "DELETE FROM evento WHERE id=?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setLong(1, idEvento);

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                bRetorno = true;
            }
        }
        return bRetorno;
    }
}
