/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nl.fontys.sevenlo.jee.taskmanager.rest;

import java.util.List;
import javax.annotation.Resource;
import javax.inject.Named;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import nl.fontys.sevenlo.jee.taskmanager.representation.CategoryRepresentation;
import nl.fontys.sevenlo.jee.taskmanager.service.CategoryService;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Vincent Wochnik <v.wochnik@gmail.com>
 */
@Named
@Path("/categories")
public class CategoryResource {
    
    @Resource
    private CategoryService categoryService;
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional(readOnly = true)
    public CategoryRepresentation find(@PathParam("id") long id) {
        return categoryService.get(id);
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional(readOnly = true)
    public List<CategoryRepresentation> findAll(@QueryParam("accountId") long accountId) {
        return categoryService.getAll(accountId);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional(readOnly = false)
    public CategoryRepresentation create(CategoryRepresentation category) {
        return categoryService.create(category);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional(readOnly = false)
    public CategoryRepresentation update(@PathParam("id") long id, CategoryRepresentation category) {
        return categoryService.update(id, category);
    }

    @DELETE
    @Path("/{id}")
    @Transactional(readOnly = false)
    public void delete(@PathParam("id") long id) {
        //TODO: implement
    }
}
