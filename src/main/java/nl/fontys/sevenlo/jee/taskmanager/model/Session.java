/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nl.fontys.sevenlo.jee.taskmanager.model;

import java.util.Date;
import javax.persistence.*;

/**
 * Represents a user session.
 * @author Vincent Wochnik <v.wochnik@gmail.com>
 */
@Entity
@Table(name = "session")
public class Session extends PossessedObject {
    
    @Column(name = "security_token", nullable = false, length = 256)
    private String securityToken;
    
    @Column(name = "last_access", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date lastAccess;

    public String getSecurityToken() {
        return securityToken;
    }

    public void setSecurityToken(String securityToken) {
        this.securityToken = securityToken;
    }

    public Date getLastAccess() {
        return lastAccess;
    }

    public void setLastAccess(Date lastAccess) {
        this.lastAccess = lastAccess;
    }
}
