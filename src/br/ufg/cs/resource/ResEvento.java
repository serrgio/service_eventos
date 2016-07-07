package br.ufg.cs.resource;

import br.ufg.cs.controller.CtrCategorias;
import br.ufg.cs.controller.CtrEvento;
import br.ufg.cs.controller.CtrFotos;
import br.ufg.cs.controller.CtrUsuario;
import br.ufg.cs.model.Categorias;
import br.ufg.cs.model.Evento;
import br.ufg.cs.model.Fotos;
import br.ufg.cs.model.Usuario;
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
 * @author Bianca Raissa
 * @author José Sérgio
 * @author Rafhael Augusto
 * @date 30/06/2016 08:51:43
 * @version 1.0
 */
@Path("/evento")
public class ResEvento {

    /**
     *
     * Resources que insere um evento no banco de dados
     *
     * @param jsonEvento
     * @return
     * @author Bianca Raissa
     * @author José Sérgio
     * @author Rafhael Augusto
     * @throws java.sql.SQLException
     * @date 30/06/2016 08:51:43
     * @version 1.0
     */
    @POST
    @Path("/insert")
    @Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
    @Consumes(MediaType.APPLICATION_JSON + "; charset=UTF-8")
    public Integer InsertEvento(String jsonEvento) throws SQLException {
        Gson gson = new Gson();
        Evento objEvento = gson.fromJson(jsonEvento, Evento.class);
        return new CtrEvento().InsertEvento(objEvento);
    }

    /**
     *
     * Resources que busca um evento no banco de dados
     *
     * @param token
     * @param idEvento
     * @return
     * @author Bianca Raissa
     * @author José Sérgio
     * @author Rafhael Augusto
     * @throws java.sql.SQLException
     * @date 30/06/2016 08:51:43
     * @version 1.0
     */
    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
    public Evento GetEvento(@PathParam("id1") String token, @PathParam("id2") int idEvento) throws SQLException {
        return new CtrEvento().GetEvento(idEvento);
    }

    /**
     *
     * Resources que busca um evento no banco de dados
     *
     * @param token
     * @param idCategoria
     * @return
     * @author Bianca Raissa
     * @author José Sérgio
     * @author Rafhael Augusto
     * @throws java.sql.SQLException
     * @date 30/06/2016 08:51:43
     * @version 1.0
     */
    @GET
    @Path("/getLst")
    @Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
    public ArrayList<Evento> GetLstEventos(@PathParam("id1") String token, @PathParam("id2") Integer idCategoria) throws SQLException {
        return new CtrEvento().GetLstEvento();
    }

    /**
     *
     * Resources que altera um evento no banco de dados
     *
     * @param token
     * @param jsonEvento
     * @return
     * @author Bianca Raissa
     * @author José Sérgio
     * @author Rafhael Augusto
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
        return new CtrEvento().UpdateEvento(objEvento);
    }

    /**
     *
     * Resources que exclui um evento no banco de dados
     *
     * @param token
     * @param idEvento
     * @return
     * @author Bianca Raissa
     * @author José Sérgio
     * @author Rafhael Augusto
     * @throws java.sql.SQLException
     * @date 30/06/2016 08:51:43
     * @version 1.0
     */
    @GET
    @Path("/delete")
    @Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
    public boolean DeleteEvento(@PathParam("id1") String token, @PathParam("id2") int idEvento) throws SQLException {
        return new CtrEvento().DeleteEvento(idEvento);
    }

    /**
     *
     * Resources que insere uma foto no banco de dados
     *
     * @param token
     * @param jsonFoto
     * @return
     * @author Bianca Raissa
     * @author José Sérgio
     * @author Rafhael Augusto
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
        return new CtrFotos().InsertFotos(objFotos);
    }

    /**
     *
     * Resources que exclui uma foto no banco de dados
     *
     * @param token
     * @param idFoto
     * @return
     * @author Bianca Raissa
     * @author José Sérgio
     * @author Rafhael Augusto
     * @throws java.sql.SQLException
     * @date 30/06/2016 08:51:43
     * @version 1.0
     */
    @GET
    @Path("/deleteFoto")
    @Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
    public boolean deleteFoto(@PathParam("id1") String token, @PathParam("id2") Integer idFoto) throws SQLException {
        return new CtrFotos().DeleteFotos(idFoto);
    }

    /**
     *
     * Resources que insere uma categoria no banco de dados
     *
     * @param token
     * @param jsonCategorias
     * @return
     * @author Bianca Raissa
     * @author José Sérgio
     * @author Rafhael Augusto
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
        return new CtrCategorias().InsertCategorias(objCategorias);
    }

    /**
     *
     * Resources que exclui uma categoria no banco de dados
     *
     * @param token
     * @param idCategorias
     * @return
     * @author Bianca Raissa
     * @author José Sérgio
     * @author Rafhael Augusto
     * @throws java.sql.SQLException
     * @date 30/06/2016 08:51:43
     * @version 1.0
     */
    @GET
    @Path("/deleteCategorias")
    @Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
    public boolean DeleteCategorias(@PathParam("id1") String token, @PathParam("id2") Integer idCategorias) throws SQLException {
        return new CtrCategorias().DeleteCategorias(idCategorias);
    }

    /**
     *
     * Resources que altera uma categoria no banco de dados
     *
     * @param token
     * @param jsonCategorias
     * @return
     * @author Bianca Raissa
     * @author José Sérgio
     * @author Rafhael Augusto
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
        Usuario objUsuario = CtrUsuario.getInstance().GetUsuario(token);
        if (objUsuario.getId() != null) {
            return new CtrCategorias().UpdateCategorias(objCategorias);
        } else {
            return false;
        }
    }
    
    /**
     *
     * Resources que busca uma lista de categorias
     *
     * @return
     * @author Bianca Raissa
     * @author José Sérgio
     * @author Rafhael Augusto
     * @throws java.sql.SQLException
     * @date 30/06/2016 08:51:43
     * @version 1.0
     */
    @GET
    @Path("/getLstCategorias")
    @Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
    public ArrayList<Categorias> GetLstEventos() throws SQLException {
        return new CtrCategorias().GetCategorias();
    }
}
