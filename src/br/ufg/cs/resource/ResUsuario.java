package br.ufg.cs.resource;

import br.ufg.cs.controller.CtrUsuario;
import br.ufg.cs.model.Token;
import br.ufg.cs.model.Usuario;
import br.ufg.cs.util.Login;
import com.google.gson.Gson;
import java.sql.SQLException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Classe respons�vel por conter os Resources dos Usuario
 *
 * @author Bianca Raissa
 * @author Jos� S�rgio
 * @author Rafhael Augusto
 * @date 30/06/2016 08:51:43
 * @version 1.0
 */
@Path("/usuario")
public class ResUsuario {

    /**
     *
     * Resources que insere um usuario no banco de dados
     *
     * @param jsonUsuario
     * @return
     * @author Bianca Raissa
     * @author Jos� S�rgio
     * @author Rafhael Augusto
     * @throws java.sql.SQLException
     * @date 30/06/2016 08:51:43
     * @version 1.0
     */
    @POST
    @Path("/insert")
    @Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
    @Consumes(MediaType.APPLICATION_JSON + "; charset=UTF-8")
    public boolean InsertUsuario(String jsonUsuario) throws SQLException {
        Gson gson = new Gson();
        Usuario objUsuario = gson.fromJson(jsonUsuario, Usuario.class);
        return new CtrUsuario().InsertUsuario(objUsuario);
    }

    /**
     *
     * Resources que busca um usuario no banco de dados
     *
     * @param jsonToken
     * @return
     * @author Bianca Raissa
     * @author Jos� S�rgio
     * @author Rafhael Augusto
     * @throws java.sql.SQLException
     * @date 30/06/2016 08:51:43
     * @version 1.0
     */
    @POST
    @Path("/buscar")
    @Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
    @Consumes(MediaType.APPLICATION_JSON + "; charset=UTF-8")
    public Usuario cadUsuario(String jsonToken) throws SQLException {
        Gson gson = new Gson();
        Token objToken = gson.fromJson(jsonToken, Token.class);
        return new CtrUsuario().GetUsuario(objToken.getValor());
    }

    /**
     *
     * Resources que altera um usuario no banco de dados
     *
     * @param token
     * @param jsonUsuario
     * @return
     * @author Bianca Raissa
     * @author Jos� S�rgio
     * @author Rafhael Augusto
     * @throws java.sql.SQLException
     * @date 30/06/2016 08:51:43
     * @version 1.0
     */
    @POST
    @Path("/update")
    @Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
    @Consumes(MediaType.APPLICATION_JSON + "; charset=UTF-8")
    public boolean UpdateUsuario(@PathParam("id") String token, String jsonUsuario) throws SQLException {
        Gson gson = new Gson();
        Usuario objUsuario = gson.fromJson(jsonUsuario, Usuario.class);
        return new CtrUsuario().UpdateUsuario(token, objUsuario);
    }

    /**
     *
     * Resources que exclui um usuario no banco de dados
     *
     * @param jsonToken
     * @author Bianca Raissa
     * @author Jos� S�rgio
     * @author Rafhael Augusto
     * @throws java.sql.SQLException
     * @date 30/06/2016 08:51:43
     * @version 1.0
     */
    @POST
    @Path("/delete")
    @Consumes(MediaType.APPLICATION_JSON + "; charset=UTF-8")
    public void DeleteUsuario(String jsonToken) throws SQLException {
        Gson gson = new Gson();
        Token objToken = gson.fromJson(jsonToken, Token.class);
        new CtrUsuario().DeleteUsuario(objToken.getValor());
    }

    /**
     *
     * Resources que exclui um usuario no banco de dados
     *
     * @param jsonUsuario
     * @return
     * @author Bianca Raissa
     * @author Jos� S�rgio
     * @author Rafhael Augusto
     * @throws java.sql.SQLException
     * @date 30/06/2016 08:51:43
     * @version 1.0
     */
    @POST
    @Path("/login")
    @Produces(MediaType.TEXT_PLAIN + "; charset=UTF-8")
    @Consumes(MediaType.APPLICATION_JSON + "; charset=UTF-8")
    public String Logar(String jsonUsuario) throws SQLException {
        Gson gson = new Gson();
        System.out.println(jsonUsuario);
        Usuario objUsuario = gson.fromJson(jsonUsuario, Usuario.class);
        return new Login().Logar(objUsuario.getEmail(), objUsuario.getSenha());
    }
}
