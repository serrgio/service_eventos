package br.ufg.cs.resource;

import br.ufg.cs.controller.CtrCategorias;
import br.ufg.cs.controller.CtrEvento;
import br.ufg.cs.controller.CtrFotos;
import br.ufg.cs.model.Categorias;
import br.ufg.cs.model.Evento;
import br.ufg.cs.model.Fotos;
import com.google.gson.Gson;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Classe responsável por conter os Resources dos Eventos
 *
 * @author José Sérgio de Souza
 * @date 30/06/2016 08:51:43
 * @version 1.0
 */
@Path("/evento")
public class ResEvento {

    /**
     *
     * Resources que insere um evento no banco de dados
     *
     * @param token
     * @param jsonEvento
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
    public boolean InsertEvento(@PathParam("id") String token, String jsonEvento) throws SQLException {
        Gson gson = new Gson();
        Evento objEvento = gson.fromJson(jsonEvento, Evento.class);
        return new CtrEvento().InsertEvento(token, objEvento);
    }

    /**
     *
     * Resources que busca um evento no banco de dados
     *
     * @param token
     * @param idEvento
     * @return
     * @author José Sérgio de Souza
     * @throws java.sql.SQLException
     * @date 30/06/2016 08:51:43
     * @version 1.0
     */
    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
    public Evento GetEvento(@PathParam("id1") String token, @PathParam("id2") int idEvento) throws SQLException {
        return new CtrEvento().GetEvento(token, idEvento);
    }

    /**
     *
     * Resources que busca um evento no banco de dados
     *
     * @param token
     * @param idCategoria
     * @return
     * @author José Sérgio de Souza
     * @throws java.sql.SQLException
     * @date 30/06/2016 08:51:43
     * @version 1.0
     */
    @GET
    @Path("/getLst")
    @Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
    public ArrayList<Evento> GetLstEventos(@PathParam("id1") String token, @PathParam("id2") Integer idCategoria) throws SQLException {
        return new CtrEvento().GetLstEvento(token, idCategoria);
    }

    /**
     *
     * Resources que altera um evento no banco de dados
     *
     * @param token
     * @param jsonEvento
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
    public boolean UpdateEvento(@PathParam("id") String token, String jsonEvento) throws SQLException {
        Gson gson = new Gson();
        Evento objEvento = gson.fromJson(jsonEvento, Evento.class);
        return new CtrEvento().UpdateEvento(token, objEvento);
    }

    /**
     *
     * Resources que exclui um evento no banco de dados
     *
     * @param token
     * @param idEvento
     * @return
     * @author José Sérgio de Souza
     * @throws java.sql.SQLException
     * @date 30/06/2016 08:51:43
     * @version 1.0
     */
    @GET
    @Path("/delete")
    @Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
    public boolean DeleteEvento(@PathParam("id1") String token, @PathParam("id2") int idEvento) throws SQLException {
        return new CtrEvento().DeleteEvento(token, idEvento);
    }

    /**
     *
     * Resources que insere uma foto no banco de dados
     *
     * @param token
     * @param jsonFoto
     * @return
     * @author José Sérgio de Souza
     * @throws java.sql.SQLException
     * @date 30/06/2016 08:51:43
     * @version 1.0
     */
    @POST
    @Path("/insertFoto")
    @Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
    @Consumes(MediaType.APPLICATION_JSON + "; charset=UTF-8")
    public boolean InsertFoto(@PathParam("id") String token, String jsonFoto) throws SQLException {
        Gson gson = new Gson();
        Fotos objFotos = gson.fromJson(jsonFoto, Fotos.class);
        return new CtrFotos().InsertFotos(token, objFotos);
    }

    /**
     *
     * Resources que exclui uma foto no banco de dados
     *
     * @param token
     * @param idFoto
     * @return
     * @author José Sérgio de Souza
     * @throws java.sql.SQLException
     * @date 30/06/2016 08:51:43
     * @version 1.0
     */
    @GET
    @Path("/deleteFoto")
    @Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
    public boolean deleteFoto(@PathParam("id1") String token, @PathParam("id2") Integer idFoto) throws SQLException {
        return new CtrFotos().DeleteFotos(token, idFoto);
    }

    /**
     *
     * Resources que insere uma categoria no banco de dados
     *
     * @param token
     * @param jsonCategorias
     * @return
     * @author José Sérgio de Souza
     * @throws java.sql.SQLException
     * @date 30/06/2016 08:51:43
     * @version 1.0
     */
    @POST
    @Path("/insertCategorias")
    @Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
    @Consumes(MediaType.APPLICATION_JSON + "; charset=UTF-8")
    public boolean InsertCategorias(@PathParam("id") String token, String jsonCategorias) throws SQLException {
        Gson gson = new Gson();
        Categorias objCategorias = gson.fromJson(jsonCategorias, Categorias.class);
        return new CtrCategorias().InsertCategorias(token, objCategorias);
    }

    /**
     *
     * Resources que exclui uma categoria no banco de dados
     *
     * @param token
     * @param idCategorias
     * @return
     * @author José Sérgio de Souza
     * @throws java.sql.SQLException
     * @date 30/06/2016 08:51:43
     * @version 1.0
     */
    @GET
    @Path("/deleteCategorias")
    @Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
    public boolean DeleteCategorias(@PathParam("id1") String token, @PathParam("id2") Integer idCategorias) throws SQLException {
        return new CtrCategorias().DeleteCategorias(token, idCategorias);
    }

    /**
     *
     * Resources que altera uma categoria no banco de dados
     *
     * @param token
     * @param jsonCategorias
     * @return
     * @author José Sérgio de Souza
     * @throws java.sql.SQLException
     * @date 30/06/2016 08:51:43
     * @version 1.0
     */
    @POST
    @Path("/updateCategorias")
    @Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
    @Consumes(MediaType.APPLICATION_JSON + "; charset=UTF-8")
    public boolean UpdateCategorias(@PathParam("id") String token, String jsonCategorias) throws SQLException {
        Gson gson = new Gson();
        Categorias objCategorias = gson.fromJson(jsonCategorias, Categorias.class);
        return new CtrCategorias().UpdateCategorias(token, objCategorias);
    }

    /**
     *
     * Resources que busca uma lista de categorias no banco de dados
     *
     * @param token
     * @return
     * @author José Sérgio de Souza
     * @throws java.sql.SQLException
     * @date 30/06/2016 08:51:43
     * @version 1.0
     */
    @GET
    @Path("/updateCategorias")
    @Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
    public ArrayList<Categorias> UpdateCategorias(@PathParam("id") String token) throws SQLException {
        return new CtrCategorias().GetCategorias(token);
    }
}
