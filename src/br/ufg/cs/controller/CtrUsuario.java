package br.ufg.cs.controller;

import br.ufg.cs.model.Usuario;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import br.ufg.cs.util.Conexao;

/**
 * Classe responsável por conter os as funções referentes ao Usuario
 *
 * @author José Sérgio de Souza
 * @date 30/06/2016 08:51:43
 * @version 1.0
 */
public class CtrUsuario extends Conexao {

    private static CtrUsuario instance;

    /**
     *
     * Método responsável por criar uma instancia da classe
     *
     * @return
     * @author José Sérgio de Souza
     * @date 30/06/2016 08:51:43
     * @version 1.0
     */
    public static CtrUsuario getInstance() {
        if (instance == null) {
            instance = new CtrUsuario();
        }
        return instance;
    }

    /**
     *
     * Método responsável por inserir um usuário no banco de dados
     *
     * @param objUsuario
     * @return
     * @author José Sérgio de Souza
     * @throws java.sql.SQLException
     * @date 15/06/2016 14:47:43
     * @version 1.0
     */
    public boolean InsertUsuario(Usuario objUsuario) throws SQLException {
        boolean bRetorno = false;
        try (Connection conn = Conectar()) {
            String sql = "INSERT INTO Usuario (nome, senha, email, dtNascimento, perfil) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, objUsuario.getNome());
            statement.setString(2, objUsuario.getSenha());
            statement.setString(1, objUsuario.getEmail());
            statement.setDate(0, (Date) objUsuario.getDtNascimento());
            statement.setInt(2, objUsuario.getPerfil());
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                bRetorno = true;
            }
        }
        return bRetorno;
    }

    /**
     *
     * Método responsável por buscar um usuário no banco de dados
     *
     * @param token
     * @return
     * @author José Sérgio de Souza
     * @throws java.sql.SQLException
     * @date 15/06/2016 14:47:43
     * @version 1.0
     */
    public Usuario GetUsuario(String token) throws SQLException {
        Usuario objUsuario = CtrThread.getInstance().GetThread(token);
        try (Connection conn = Conectar()) {
            String sql = "SELECT nome, email, dtNascimento, perfil FROM Usuario WHERE id=" + objUsuario.getId();

            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);

            if (result.next()) {
                objUsuario.setNome(result.getString(1));
                objUsuario.setEmail(result.getString(2));
                objUsuario.setDtNascimento(result.getDate(3));
                objUsuario.setPerfil(result.getInt(4));
            }
        }
        return objUsuario;
    }

    /**
     *
     * Método responsável por alterar um usuário no banco de dados
     *
     * @param token
     * @param objUsuario
     * @return
     * @author José Sérgio de Souza
     * @throws java.sql.SQLException
     * @date 15/06/2016 14:47:43
     * @version 1.0
     */
    public boolean UpdateUsuario(String token, Usuario objUsuario) throws SQLException {
        boolean bRetorno = false;

        try (Connection conn = Conectar()) {
            String sql = "UPDATE Usuario SET nome=?, senha=?, email=?, dtNascimento=?, perfil=? WHERE id=?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, objUsuario.getNome());
            statement.setString(2, objUsuario.getSenha());
            statement.setString(3, objUsuario.getEmail());
            statement.setDate(4, (Date) objUsuario.getDtNascimento());
            statement.setInt(5, objUsuario.getPerfil());
            statement.setLong(6, objUsuario.getId());

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                bRetorno = true;
            }
        }
        return bRetorno;
    }

    /**
     *
     * Método responsável por excluir um usuário no banco de dados
     *
     * @param token
     * @return
     * @author José Sérgio de Souza
     * @throws java.sql.SQLException
     * @date 15/06/2016 14:47:43
     * @version 1.0
     */
    public boolean DeleteUsuario(String token) throws SQLException {
        boolean bRetorno = false;
        Usuario objUsuario = CtrThread.getInstance().GetThread(token);
        try (Connection conn = Conectar()) {
            String sql = "DELETE FROM Usuario WHERE id=?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setLong(1, objUsuario.getId());

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                bRetorno = true;
            }
        }
        return bRetorno;
    }
}
