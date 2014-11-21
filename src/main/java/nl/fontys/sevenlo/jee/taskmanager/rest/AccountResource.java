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
import javax.ws.rs.core.MediaType;
import nl.fontys.sevenlo.jee.taskmanager.representation.AccountRepresentation;
import nl.fontys.sevenlo.jee.taskmanager.service.AccountService;
import org.jboss.resteasy.links.AddLinks;
import org.jboss.resteasy.links.LinkResource;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Vincent Wochnik <v.wochnik@gmail.com>
 */
@Named
@Path("/accounts")
public class AccountResource {
    
    @Resource
    private AccountService accountService;
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional(readOnly = true)
    public AccountRepresentation find(@PathParam("id") long id) {
        return accountService.get(id);
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @AddLinks
    @LinkResource(value = AccountRepresentation.class)
    @Transactional(readOnly = true)
    public List<AccountRepresentation> findAll() {
        return accountService.getAll();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional(readOnly = false)
    public AccountRepresentation create(AccountRepresentation account) {
        return accountService.create(account);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional(readOnly = false)
    public AccountRepresentation update(@PathParam("id") long id, AccountRepresentation account) {
        return accountService.update(id, account);
    }

    @DELETE
    @Path("/{id}")
    @Transactional(readOnly = false)
    public void delete(@PathParam("id") long id) {
        accountService.delete(id);
    }
}
