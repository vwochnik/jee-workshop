/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nl.fontys.sevenlo.jee.taskmanager.representation;

import org.jboss.resteasy.spi.touri.URITemplate;

/**
 *
 * @author Vincent Wochnik <v.wochnik@gmail.com>
 */
@URITemplate("/tasks/{id}")
public class TaskRepresentation extends DomainObjectRepresentation {

    private ObjectReferenceRepresentation account;
    private ObjectReferenceRepresentation category;
    private String label;
    private String description;
    private Integer importance;
    private Integer urgency;

    public ObjectReferenceRepresentation getAccount() {
        return account;
    }

    public void setAccount(ObjectReferenceRepresentation account) {
        this.account = account;
    }

    public ObjectReferenceRepresentation getCategory() {
        return category;
    }

    public void setCategory(ObjectReferenceRepresentation category) {
        this.category = category;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getImportance() {
        return importance;
    }

    public void setImportance(Integer importance) {
        this.importance = importance;
    }

    public Integer getUrgency() {
        return urgency;
    }

    public void setUrgency(Integer urgency) {
        this.urgency = urgency;
    }
}
