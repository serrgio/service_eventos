package br.ufg.cs.resource;

import br.ufg.cs.controller.CtrUsuario;
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
 * Classe responsável por conter os Resources dos Usuario
 *
 * @author José Sérgio de Souza
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
     * @author José Sérgio de Souza
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
     * @param token
     * @return
     * @author José Sérgio de Souza
     * @throws java.sql.SQLException
     * @date 30/06/2016 08:51:43
     * @version 1.0
     */
    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
    public Usuario cadUsuario(@PathParam("id") String token) throws SQLException {
        return new CtrUsuario().GetUsuario(token);
    }

    /**
     *
     * Resources que altera um usuario no banco de dados
     *
     * @param token
     * @param jsonUsuario
     * @return
     * @author José Sérgio de Souza
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
     * @param token
     * @return
     * @author José Sérgio de Souza
     * @throws java.sql.SQLException
     * @date 30/06/2016 08:51:43
     * @version 1.0
     */
    @GET
    @Path("/delete")
    @Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
    public boolean DeleteUsuario(@PathParam("id") String token) throws SQLException {
        return new CtrUsuario().DeleteUsuario(token);
    }
    
    /**
     *
     * Resources que loga um usuario
     *
     * @param email
     * @param senha
     * @return
     * @author José Sérgio de Souza
     * @throws java.sql.SQLException
     * @date 30/06/2016 08:51:43
     * @version 1.0
     */
    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
    public String cadUsuario(@PathParam("id1") String email, @PathParam("id2") String senha) throws SQLException {
        return new Login().Logar(email, senha);
    }

}
