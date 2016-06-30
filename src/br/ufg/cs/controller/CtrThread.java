package br.ufg.cs.controller;

import br.ufg.cs.model.Usuario;
import br.ufg.cs.util.Conexao;
import br.ufg.cs.util.Miscelanea;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Classe responsável por conter os as funções referentes a Thread
 *
 * @author José Sérgio de Souza
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
     * @author José Sérgio de Souza
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
     * @author José Sérgio de Souza
     * @throws java.sql.SQLException
     * @date 30/06/2016 08:51:43
     * @version 1.0
     */
    public String InsertThread(Usuario objUsuario) throws SQLException {
        String sToken = Miscelanea.getInstance().MD5(objUsuario.getEmail());
        try (Connection conn = Conectar()) {
            String sql = "INSERT INTO thread (idusuario, dtcriacao, dtalteracao, perfil, stoken) VALUES (?, NOW(), NOW(), ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setLong(1, objUsuario.getId());
            statement.setInt(4, objUsuario.getPerfil());
            statement.setString(5, sToken);
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted == 0) {
                sToken = "";
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
     * @author José Sérgio de Souza
     * @throws java.sql.SQLException
     * @date 30/06/2016 08:51:43
     * @version 1.0
     */
    public Usuario GetThread(String token) throws SQLException {
        Usuario objUsuario = CtrThread.getInstance().GetThread(token);
        try (Connection conn = Conectar()) {
            String sql = "SELECT idusuario, dtnascimento, email, idendereco, nome, perfil "
                    + "FROM thread a "
                    + "LEFT JOIN usuario b ON d.id = a.idusuario "
                    + "WHERE stoken=" + objUsuario.getId();

            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);

            if (result.next()) {
                objUsuario.setId(result.getLong(1));
                objUsuario.setDtNascimento(result.getDate(2));
                objUsuario.setEmail(result.getString(3));
                objUsuario.setNome(result.getString(5));
                objUsuario.setPerfil(result.getInt(6));
            }
        }
        return objUsuario;
    }

    /**
     *
     * Método responsável por alterar uma thread no banco de dados
     *
     * @param objUsuario
     * @return
     * @author José Sérgio de Souza
     * @throws java.sql.SQLException
     * @date 30/06/2016 08:51:43
     * @version 1.0
     */
    public boolean UpdateThread(Usuario objUsuario) throws SQLException {
        return true;
    }
}
