package br.ufg.cs.controller;

import br.ufg.cs.model.Usuario;
import br.ufg.cs.util.Conexao;
import br.ufg.cs.util.Miscelanea;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

/**
 * Classe responsável por conter os as funções referentes a Thread
 *
 * @author Bianca Raissa
 * @author José Sérgio
 * @author Rafhael Augusto
 * @date 30/06/2016 08:51:43
 * @version 1.0
 */
public class CtrThread extends Conexao {

    private static CtrThread instance;

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
    public static CtrThread getInstance() {
        if (instance == null) {
            instance = new CtrThread();
        }
        return instance;
    }

    /**
     *
     * Método responsável por inserir uma thread no banco de dados
     *
     * @param objUsuario
     * @return
     * @author Bianca Raissa
     * @author José Sérgio
     * @author Rafhael Augusto
     * @throws java.sql.SQLException
     * @date 30/06/2016 08:51:43
     * @version 1.0
     */
    public String InsertThread(Usuario objUsuario) throws SQLException {
        Date dtAtual = new Date();
        String sToken = Miscelanea.getInstance().MD5(objUsuario.getEmail() + dtAtual);
        try (Connection conn = Conexao.getInstance().Conectar()) {
            String sql = "INSERT INTO thread (idusuario, dtcriacao, dtalteracao, perfil, stoken, status) VALUES (?, NOW(), NOW(), ?, ?, ?)";
            try (PreparedStatement statement = conn.prepareStatement(sql)) {
                statement.setInt(1, objUsuario.getId());
                statement.setInt(2, objUsuario.getPerfil());
                statement.setString(3, sToken);
                statement.setInt(4, 1);
                if (statement.execute()) {
                    System.out.println("OK");
                }
            }
        }
        return sToken;
    }

    /**
     *
     * Método responsável por buscar uma thread no banco de dados
     *
     * @param token
     * @return
     * @author Bianca Raissa
     * @author José Sérgio
     * @author Rafhael Augusto
     * @throws java.sql.SQLException
     * @date 30/06/2016 08:51:43
     * @version 1.0
     */
    public Integer GetThread(String token) throws SQLException {
        Integer iRetorno = null;
        try (Connection conn = Conexao.getInstance().Conectar()) {
            String sql = "SELECT idusuario FROM thread WHERE stoken='" + token +"'";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            if (result.next()) {
                iRetorno = result.getInt(1);
            }
        }
        return iRetorno;
    }

    /**
     *
     * Método responsável por alterar uma thread no banco de dados
     *
     * @param sToken
     * @return
     * @author Bianca Raissa
     * @author José Sérgio
     * @author Rafhael Augusto
     * @throws java.sql.SQLException
     * @date 30/06/2016 08:51:43
     * @version 1.0
     */
    public boolean UpdateThread(String sToken) throws SQLException {
        boolean bRetorno = false;

        try (Connection conn = Conexao.getInstance().Conectar()) {
            String sql = "UPDATE thread SET dtAlteracao=NOW() WHERE stoken=?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, sToken);

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                bRetorno = true;
            }
        }
        return bRetorno;
    }

    /**
     *
     * Método responsável por alterar uma thread no banco de dados
     *
     * @author Bianca Raissa
     * @author José Sérgio
     * @author Rafhael Augusto
     * @throws java.sql.SQLException
     * @date 30/06/2016 08:51:43
     * @version 1.0
     */
    public void StatusThread() throws SQLException {
        try (Connection conn = Conexao.getInstance().Conectar()) {
            String sql = "UPDATE thread SET status=0 WHERE TIMESTAMPDIFF(MINUTE,dtAlteracao,NOW()) > 30";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.execute();
        }
    }
}
