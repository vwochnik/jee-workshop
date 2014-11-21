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
@URITemplate("/categories/{id}")
public class CategoryRepresentation extends DomainObjectRepresentation {

    private ObjectReferenceRepresentation account;
    private String label;
    private Integer hue;

    public ObjectReferenceRepresentation getAccount() {
        return account;
    }

    public void setAccount(ObjectReferenceRepresentation account) {
        this.account = account;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Integer getHue() {
        return hue;
    }

    public void setHue(Integer hue) {
        this.hue = hue;
    }
}
