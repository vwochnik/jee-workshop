/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nl.fontys.sevenlo.jee.taskmanager.model;

import java.util.List;
import javax.persistence.*;

/**
 * Represents an application user.
 * @author Vincent Wochnik <v.wochnik@gmail.com>
 */
@Entity
@Table(name = "account")
public class Account extends DomainObject {
    
    @Column(name = "email", unique = true, nullable = false, length = 128)
    private String email;
    
    @Column(name = "password", nullable = false, length = 256)
    private String password;

    @Column(name = "display_name", nullable = false, length = 256)
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
