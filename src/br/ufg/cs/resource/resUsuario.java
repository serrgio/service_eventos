/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.cs.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Jos� S�rgio de Souza
 */
@Path("/usuario")
public class resUsuario {

    @GET
    @Path("/cadastrar")
    @Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
    public String cadUsuario() {
        return null;
    }
}
