/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nl.fontys.sevenlo.jee.taskmanager.representation;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jboss.resteasy.spi.touri.ObjectToURI;

/**
 *
 * @author Vincent Wochnik <v.wochnik@gmail.com>
 */
public abstract class DomainObjectRepresentation {
    
    @JsonProperty(value = "id", required = false)
    private Long id;

    @JsonProperty(value = "self", required = false)
    public String getSelf() {
        return ObjectToURI.getInstance().resolveURI(this);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
