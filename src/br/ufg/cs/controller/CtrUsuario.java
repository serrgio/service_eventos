package br.ufg.cs.controller;

import br.ufg.cs.model.Usuario;
import static br.ufg.cs.util.Conexao.Conectar;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static br.ufg.cs.controller.CtrThread.GetThread;


/**
 *
 * Created by José Sergio on 16/06/2016.
 */
public class CtrUsuario {

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

    public Usuario GetUsuario(String token) throws SQLException {        
        Usuario objUsuario = GetThread(token);
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

    public boolean UpdateUsuario(Usuario objUsuario) throws SQLException {
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

    public boolean DeleteUsuario(Integer idUsuario) throws SQLException {
        boolean bRetorno = false;

        try (Connection conn = Conectar()) {
            String sql = "DELETE FROM Usuario WHERE id=?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, idUsuario);

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                bRetorno = true;
            }
        }
        return bRetorno;
    }
}
