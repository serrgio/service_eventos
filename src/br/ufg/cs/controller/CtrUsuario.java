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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe responsável por conter os as funções referentes ao Usuario
 *
 * @author Bianca Raissa
 * @author José Sérgio
 * @author Rafhael Augusto
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
     * @author Bianca Raissa
     * @author José Sérgio
     * @author Rafhael Augusto
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
     * @author Bianca Raissa
     * @author José Sérgio
     * @author Rafhael Augusto
     * @throws java.sql.SQLException
     * @date 15/06/2016 14:47:43
     * @version 1.0
     */
    public boolean InsertUsuario(Usuario objUsuario) throws SQLException {
        boolean bRetorno = false;
        try (Connection conn = Conexao.getInstance().Conectar()) {
            String sql = "INSERT INTO Usuario (nome, senha, email, dtNascimento, perfil, idEndereco) VALUES (?, ?, ?, ?, ?, ?)";
            try (PreparedStatement statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                statement.setString(1, objUsuario.getNome());
                statement.setString(2, objUsuario.getSenha());
                statement.setString(3, objUsuario.getEmail());
                statement.setDate(4, (Date) Miscelanea.getInstance().ConverterData(objUsuario.getDtNascimento()));
                statement.setInt(5, objUsuario.getPerfil());
                statement.setInt(6, CtrEndereco.getInstance().InsertEndereco(objUsuario.getEndereco()));
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
     * Método responsável por buscar um usuário no banco de dados
     *
     * @param token
     * @return
     * @author Bianca Raissa
     * @author José Sérgio
     * @author Rafhael Augusto
     * @throws java.sql.SQLException
     * @date 15/06/2016 14:47:43
     * @version 1.0
     */
    public Usuario GetUsuario(String token) throws SQLException {
        Usuario objUsuario = new Usuario();
        Integer idUsuario = CtrThread.getInstance().GetThread(token);
        objUsuario.setId(idUsuario);
        try (Connection conn = Conexao.getInstance().Conectar()) {
            String sql = "SELECT nome, email, dtNascimento, perfil, idendereco FROM Usuario WHERE id=" + idUsuario;

            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);

            if (result.next()) {
                objUsuario.setNome(result.getString(1));
                objUsuario.setEmail(result.getString(2));
                objUsuario.setDtNascimento(result.getDate(3));
                objUsuario.setPerfil(result.getInt(4));
                int aux = result.getInt(5);
                if (aux > 0) {
                    objUsuario.setEndereco(CtrEndereco.getInstance().GetEndereco(aux));
                }

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
     * @author Bianca Raissa
     * @author José Sérgio
     * @author Rafhael Augusto
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
     * Método responsável por excluir um usuário no banco de dados
     *
     * @param token
     * @author Bianca Raissa
     * @author José Sérgio
     * @author Rafhael Augusto
     * @throws java.sql.SQLException
     * @date 15/06/2016 14:47:43
     * @version 1.0
     */
    public void DeleteUsuario(String token) throws SQLException {
        Usuario objUsuario = new Usuario();
        objUsuario.setId(CtrThread.getInstance().GetThread(token));
        try (Connection conn = Conexao.getInstance().Conectar()) {
            String sql = "DELETE FROM Usuario WHERE id=?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setLong(1, objUsuario.getId());
            statement.executeUpdate();
        }
    }
}
