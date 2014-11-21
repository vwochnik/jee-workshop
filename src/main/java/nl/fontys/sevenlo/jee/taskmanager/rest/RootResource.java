/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nl.fontys.sevenlo.jee.taskmanager.rest;

import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import nl.fontys.sevenlo.jee.taskmanager.representation.RootResourceRepresentation;

/**
 *
 * @author Vincent Wochnik <v.wochnik@gmail.com>
 */
@Named
@Path("/")
public class RootResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public RootResourceRepresentation hello() {
        return new RootResourceRepresentation();
    }
}
