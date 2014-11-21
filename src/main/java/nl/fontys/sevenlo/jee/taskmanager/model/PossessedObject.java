/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nl.fontys.sevenlo.jee.taskmanager.model;

import javax.persistence.*;

/**
 * Represents a domain object possessed by a user account.
 * @author Vincent Wochnik <v.wochnik@gmail.com>
 */
@MappedSuperclass
public class PossessedObject extends DomainObject {

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "account")
    private Account account;

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

}
