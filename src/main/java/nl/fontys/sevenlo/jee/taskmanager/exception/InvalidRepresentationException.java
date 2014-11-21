/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nl.fontys.sevenlo.jee.taskmanager.exception;

import javax.ws.rs.core.Response;

/**
 *
 * @author Vincent Wochnik <v.wochnik@gmail.com>
 */
public class InvalidRepresentationException extends ResourceException {

    public InvalidRepresentationException(String message) {
        super(message);
    }

    public InvalidRepresentationException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidRepresentationException(Throwable cause) {
        super(cause);
    }

    @Override
    public Response.Status getStatus() {
        return Response.Status.BAD_REQUEST;
    }
}
