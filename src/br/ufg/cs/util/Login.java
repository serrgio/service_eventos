package br.ufg.cs.util;

import br.ufg.cs.controller.CtrThread;
import br.ufg.cs.model.Usuario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Classe respons�vel por conter os as fun��es de login
 *
 * @author Jos� S�rgio de Souza
 * @date 30/06/2016 08:51:43
 * @version 1.0
 */
public class Login extends Conexao {

    private static Login instance;

    /**
     *
     * M�todo respons�vel por criar uma instancia da classe
     *
     * @return
     * @author Jos� S�rgio de Souza
     * @date 30/06/2016 08:51:43
     * @version 1.0
     */
    public static Login getInstance() {
        if (instance == null) {
            instance = new Login();
        }
        return instance;
    }

    /**
     *
     * M�todo respons�vel por excluir uma categoria de eventos no banco de dados
     *
     * @param email
     * @param senha
     * @return
     * @author Jos� S�rgio de Souza
     * @throws java.sql.SQLException
     * @date 30/06/2016 08:51:43
     * @version 1.0
     */
    public String Logar(String email, String senha) throws SQLException {
        String sToken = "";
        try (Connection conn = Conexao.getInstance().Conectar()) {
            String sql = "SELECT id, email, senha"
                    + "FROM usuario a "
                    + "WHERE email=" + email
                    + "AND senha" + senha;
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            Usuario objUsuario = new Usuario();
            if (result.next()) {
                objUsuario.setId(result.getInt(1));
                objUsuario.setEmail(result.getString(3));
                objUsuario.setPerfil(result.getInt(6));
            }
            if (objUsuario.getId()!=null) {
                sToken = CtrThread.getInstance().InsertThread(objUsuario);
            }
        }
        return sToken;
    }
}
