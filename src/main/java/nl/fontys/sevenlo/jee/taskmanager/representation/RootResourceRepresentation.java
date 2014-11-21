/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.fontys.sevenlo.jee.taskmanager.representation;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author Vincent
 */
public class RootResourceRepresentation {

    @JsonProperty(value = "accountResource")
    private final String accountResource = "/accounts/";

    @JsonProperty(value = "categoryResource")
    private final String categoryResource = "/categories/";

    @JsonProperty(value = "taskResource")
    private final String taskResource = "/tasks/";
}
