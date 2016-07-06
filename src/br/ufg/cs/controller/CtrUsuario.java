package br.ufg.cs.controller;

import br.ufg.cs.model.Usuario;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import br.ufg.cs.util.Conexao;
import br.ufg.cs.util.Miscelanea;

/**
 * Classe respons�vel por conter os as fun��es referentes ao Usuario
 *
 * @author Jos� S�rgio de Souza
 * @date 30/06/2016 08:51:43
 * @version 1.0
 */
public class CtrUsuario extends Conexao {

    private static CtrUsuario instance;

    /**
     *
     * M�todo respons�vel por criar uma instancia da classe
     *
     * @return
     * @author Jos� S�rgio de Souza
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
     * M�todo respons�vel por inserir um usu�rio no banco de dados
     *
     * @param objUsuario
     * @return
     * @author Jos� S�rgio de Souza
     * @throws java.sql.SQLException
     * @date 15/06/2016 14:47:43
     * @version 1.0
     */
    public boolean InsertUsuario(Usuario objUsuario) throws SQLException {
        boolean bRetorno = false;
        try (Connection conn = Conexao.getInstance().Conectar()) {
            String sql = "INSERT INTO Usuario (nome, senha, email, dtNascimento, perfil) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                statement.setString(1, objUsuario.getNome());
                statement.setString(2, objUsuario.getSenha());
                statement.setString(3, objUsuario.getEmail());
                statement.setDate(4, (Date) Miscelanea.getInstance().ConverterData(objUsuario.getDtNascimento()));
                statement.setInt(5, objUsuario.getPerfil());
                statement.executeUpdate();
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    System.out.println(generatedKeys.getInt(1));
                }
                bRetorno = true;
            }
        }
        return bRetorno;
    }

    /**
     *
     * M�todo respons�vel por buscar um usu�rio no banco de dados
     *
     * @param token
     * @return
     * @author Jos� S�rgio de Souza
     * @throws java.sql.SQLException
     * @date 15/06/2016 14:47:43
     * @version 1.0
     */
    public Usuario GetUsuario(String token) throws SQLException {
        Usuario objUsuario = CtrThread.getInstance().GetThread(token);
        try (Connection conn = Conexao.getInstance().Conectar()) {
            String sql = "SELECT nome, email, dtNascimento, perfil FROM Usuario WHERE id=" + objUsuario.getEmail();

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
     * M�todo respons�vel por alterar um usu�rio no banco de dados
     *
     * @param token
     * @param objUsuario
     * @return
     * @author Jos� S�rgio de Souza
     * @throws java.sql.SQLException
     * @date 15/06/2016 14:47:43
     * @version 1.0
     */
    public boolean UpdateUsuario(String token, Usuario objUsuario) throws SQLException {
        boolean bRetorno = false;

        try (Connection conn = Conexao.getInstance().Conectar()) {
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
     * M�todo respons�vel por excluir um usu�rio no banco de dados
     *
     * @param token
     * @return
     * @author Jos� S�rgio de Souza
     * @throws java.sql.SQLException
     * @date 15/06/2016 14:47:43
     * @version 1.0
     */
    public boolean DeleteUsuario(String token) throws SQLException {
        boolean bRetorno = false;
        Usuario objUsuario = CtrThread.getInstance().GetThread(token);
        try (Connection conn = Conexao.getInstance().Conectar()) {
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
