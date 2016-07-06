package br.ufg.cs.controller;

import br.ufg.cs.model.Fotos;
import br.ufg.cs.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Classe responsável por conter os as funções referentes as Fotos dos Eventos
 *
 * @author Bianca Raissa
 * @author José Sérgio
 * @author Rafhael Augusto
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
     * @author Bianca Raissa
     * @author José Sérgio
     * @author Rafhael Augusto
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
     * @param objFotos
     * @return
     * @author Bianca Raissa
     * @author José Sérgio
     * @author Rafhael Augusto
     * @throws java.sql.SQLException
     * @date 30/06/2016 08:51:43
     * @version 1.0
     */
    public boolean InsertFotos(Fotos objFotos) throws SQLException {
        boolean bRetorno = false;
        try (Connection conn = Conexao.getInstance().Conectar()) {
            String sql = "INSERT INTO fotos(idEvento, nome, descricao, dtFoto) VALUES (?,?,?,NOW())";
            PreparedStatement statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, objFotos.getIdEvento());
            statement.setString(2, objFotos.getNome());
            statement.setString(3, objFotos.getDescricao());
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                bRetorno = true;
            }
        }
        return bRetorno;
    }

    /**
     *
     * Método responsável por inserir uma foto no banco de dados
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
    public ArrayList<Fotos> GetFotos(Integer idEvento) throws SQLException {
        ArrayList<Fotos> lstFotos = new ArrayList<>();
        try (Connection conn = Conexao.getInstance().Conectar()) {
            String sql = "SELECT id, idEvento, nome, descricao, dtFoto FROM fotos WHERE iDevento=" + idEvento;

            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
                Fotos objFotos = new Fotos();
                objFotos.setId(result.getInt(1));
                objFotos.setIdEvento(result.getInt(2));
                objFotos.setNome(result.getString(3));
                objFotos.setDescricao(result.getString(4));
                objFotos.setDtFoto(result.getDate(5));
                lstFotos.add(objFotos);
            }
        }
        return lstFotos;
    }

    /**
     *
     * Método responsável por excluir uma foto no banco de dados
     *
     * @param idFotos
     * @return
     * @author Bianca Raissa
     * @author José Sérgio
     * @author Rafhael Augusto
     * @throws java.sql.SQLException
     * @date 30/06/2016 08:51:43
     * @version 1.0
     */
    public boolean DeleteFotos(Integer idFotos) throws SQLException {
        boolean bRetorno = false;
        try (Connection conn = Conexao.getInstance().Conectar()) {
            String sql = "DELETE FROM fotos WHERE id=?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setLong(1, idFotos);

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                bRetorno = true;
            }
        }
        return bRetorno;
    }
}
