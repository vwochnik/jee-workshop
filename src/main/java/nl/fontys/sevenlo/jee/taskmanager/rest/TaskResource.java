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
import nl.fontys.sevenlo.jee.taskmanager.representation.TaskRepresentation;
import nl.fontys.sevenlo.jee.taskmanager.service.TaskService;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Vincent Wochnik <v.wochnik@gmail.com>
 */
@Named
@Path("/tasks")
public class TaskResource {
    
    @Resource
    private TaskService taskService;
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional(readOnly = true)
    public TaskRepresentation find(@PathParam("id") long id) {
        return taskService.get(id);
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional(readOnly = true)
    public List<TaskRepresentation> findAll(@QueryParam("accountId") long accountId) {
        return taskService.getAll(accountId);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional(readOnly = false)
    public TaskRepresentation create(TaskRepresentation task) {
        return taskService.create(task);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional(readOnly = false)
    public TaskRepresentation update(@PathParam("id") long id, TaskRepresentation task) {
        //TODO: implement
        return null;
    }

    @DELETE
    @Path("/{id}")
    @Transactional(readOnly = false)
    public void delete(@PathParam("id") long id) {
        //TODO: implement
    }
}
