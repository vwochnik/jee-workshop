/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nl.fontys.sevenlo.jee.taskmanager.handler;

import javax.inject.Named;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import nl.fontys.sevenlo.jee.taskmanager.exception.ResourceException;

/**
 *
 * @author Vincent Wochnik <v.wochnik@gmail.com>
 */
@Provider
@Named
public class ResourceExceptionMapper implements ExceptionMapper<ResourceException> {

    @Override
    public Response toResponse(ResourceException exception) {
        return Response.status(exception.getStatus()).entity(new ExceptionEntity(exception)).build();
    }
    
    public static class ExceptionEntity {
        private final Exception exception;
        
        public ExceptionEntity(Exception exception) {
            this.exception = exception;
        }
        
        //TODO: implement json serialization getter
    }
}