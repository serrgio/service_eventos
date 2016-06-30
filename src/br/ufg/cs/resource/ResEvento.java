package br.ufg.cs.resource;

import br.ufg.cs.controller.CtrEvento;
import br.ufg.cs.model.Evento;
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
 * Created by Jos� Sergio on 16/06/2016.
 */
@Path("/evento")
public class ResEvento {
    @POST
    @Path("/insert")
    @Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
    @Consumes(MediaType.APPLICATION_JSON + "; charset=UTF-8")
    public boolean InsertEvento(@PathParam("id") String token, String jsonEvento) throws SQLException {
        Gson gson = new Gson();
        Evento objEvento = gson.fromJson(jsonEvento, Evento.class);
        return new CtrEvento().InsertEvento(token, objEvento);
    }
    
    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
    public Evento GetEvento(@PathParam("id1") String token, @PathParam("id2") int idEvento) throws SQLException {        
        return new CtrEvento().GetEvento(token, idEvento);
    }
    
    @POST
    @Path("/update")
    @Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
    @Consumes(MediaType.APPLICATION_JSON + "; charset=UTF-8")
    public boolean UpdateEvento(@PathParam("id") String token, String jsonEvento) throws SQLException {
        Gson gson = new Gson();
        Evento objEvento = gson.fromJson(jsonEvento, Evento.class);
        return new CtrEvento().UpdateEvento(token, objEvento);
    }
    
    @GET
    @Path("/delete")
    @Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
    public boolean DeleteEvento(@PathParam("id1") String token, @PathParam("id2") int idEvento) throws SQLException {        
        return new CtrEvento().DeleteEvento(token, idEvento);
    }
}
