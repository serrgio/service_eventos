package br.ufg.cs.resource;

import br.ufg.cs.controller.CtrUsuario;
import br.ufg.cs.model.Usuario;
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
 * Created by José Sergio on 16/06/2016.
 */
@Path("/usuario")
public class resUsuario {

    @POST
    @Path("/insert")
    @Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
    @Consumes(MediaType.APPLICATION_JSON + "; charset=UTF-8")
    public boolean InsertUsuario(String jsonUsuario) throws SQLException {
        Gson gson = new Gson();
        Usuario objUsuario = gson.fromJson(jsonUsuario, Usuario.class);
        return new CtrUsuario().InsertUsuario(objUsuario);
    }
    
    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
    public Usuario cadUsuario(@PathParam("id") String token) throws SQLException {        
        return new CtrUsuario().GetUsuario(token);
    }
    
    @POST
    @Path("/update")
    @Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
    @Consumes(MediaType.APPLICATION_JSON + "; charset=UTF-8")
    public boolean UpdateUsuario(@PathParam("id") String token, String jsonUsuario) throws SQLException {
        Gson gson = new Gson();
        Usuario objUsuario = gson.fromJson(jsonUsuario, Usuario.class);
        return new CtrUsuario().UpdateUsuario(token, objUsuario);
    }
    
    @GET
    @Path("/delete")
    @Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
    public boolean DeleteUsuario(@PathParam("id") String token) throws SQLException {        
        return new CtrUsuario().DeleteUsuario(token);
    }

}
