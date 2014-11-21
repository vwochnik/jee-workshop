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
@URITemplate("/accounts/{id}")
public class AccountRepresentation extends DomainObjectRepresentation {

    private String email;
    private String password;
    private String displayName;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
}
