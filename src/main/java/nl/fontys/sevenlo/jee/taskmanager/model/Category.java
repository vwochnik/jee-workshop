/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nl.fontys.sevenlo.jee.taskmanager.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author Vincent Wochnik <v.wochnik@gmail.com>
 */
@Entity
@Table(name = "category")
public class Category extends PossessedObject {

    @Column(name = "label", unique = false, nullable = false, length = 256)
    private String label;

    @Column(name = "hue", unique = false, nullable = false)
    private Integer hue;

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
