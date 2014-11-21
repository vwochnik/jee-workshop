/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nl.fontys.sevenlo.jee.taskmanager.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Represents an abstract domain object.
 * @author Vincent Wochnik <v.wochnik@gmail.com>
 */
@MappedSuperclass
public class DomainObject implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
