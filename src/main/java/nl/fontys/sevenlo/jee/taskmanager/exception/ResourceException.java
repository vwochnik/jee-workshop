/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nl.fontys.sevenlo.jee.taskmanager.exception;

import javax.ws.rs.core.Response.Status;

/**
 *
 * @author Vincent Wochnik <v.wochnik@gmail.com>
 */
public abstract class ResourceException extends RuntimeException {

    public ResourceException(String message) {
        super(message);
    }

    public ResourceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ResourceException(Throwable cause) {
        super(cause);
    }
    
    public abstract Status getStatus();
}
