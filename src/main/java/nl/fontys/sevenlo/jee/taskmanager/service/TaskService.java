/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nl.fontys.sevenlo.jee.taskmanager.service;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import nl.fontys.sevenlo.jee.taskmanager.exception.DatabaseException;
import nl.fontys.sevenlo.jee.taskmanager.exception.InvalidQueryException;
import nl.fontys.sevenlo.jee.taskmanager.exception.InvalidRepresentationException;
import nl.fontys.sevenlo.jee.taskmanager.exception.ResourceNotFoundException;
import nl.fontys.sevenlo.jee.taskmanager.model.Account;
import nl.fontys.sevenlo.jee.taskmanager.model.Category;
import nl.fontys.sevenlo.jee.taskmanager.model.Task;
import nl.fontys.sevenlo.jee.taskmanager.repository.AccountRepository;
import nl.fontys.sevenlo.jee.taskmanager.repository.CategoryRepository;
import nl.fontys.sevenlo.jee.taskmanager.repository.TaskRepository;
import nl.fontys.sevenlo.jee.taskmanager.representation.AccountRepresentation;
import nl.fontys.sevenlo.jee.taskmanager.representation.CategoryRepresentation;
import nl.fontys.sevenlo.jee.taskmanager.representation.ObjectReferenceRepresentation;
import nl.fontys.sevenlo.jee.taskmanager.representation.TaskRepresentation;
import org.springframework.stereotype.Service;

/**
 *
 * @author Vincent Wochnik <v.wochnik@gmail.com>
 */
@Service
public class TaskService {
    
    @Resource
    private TaskRepository taskRepository;
    @Resource
    private AccountRepository accountRepository;
    @Resource
    private CategoryRepository categoryRepository;
    
    public List<TaskRepresentation> getAll(Long accountId) {
        List<TaskRepresentation> resultList = new ArrayList<TaskRepresentation>();
        
        Account account = accountRepository.findOne(accountId);
        if (account == null)
            throw new InvalidQueryException("Account ID not found.");

        for (Task task : taskRepository.findByAccount(account)) {
            resultList.add(representation(task));
        }
        
        return resultList;
    }
    
    public TaskRepresentation get(Long id) {
        Task task = taskRepository.getOne(id);
        if (task == null)
            throw new ResourceNotFoundException("Task ID not found.");

        return representation(task);
    }
    
    public TaskRepresentation create(TaskRepresentation repr) {
        if (repr.getId() != null)
            throw new InvalidRepresentationException("Resource ID must not be specified for a create operation.");

        Task task = model(repr);
        if (task.getAccount() == null)
            throw new InvalidRepresentationException("Invalid account ID specified.");
        if (task.getCategory()== null)
            throw new InvalidRepresentationException("Invalid category ID specified.");

        task = taskRepository.save(task);
        if (task == null)
            throw new DatabaseException("Task could not be created.");

        return representation(task);
    }
    
    public TaskRepresentation update(Long id, TaskRepresentation repr) {
        //TODO: implement
        return null;
    }
    
    public void delete(Long id) {
        //TODO: implement
    }
    
    private TaskRepresentation representation(Task task) {
        TaskRepresentation result = new TaskRepresentation();
        ObjectReferenceRepresentation accountRepr = new ObjectReferenceRepresentation();
        ObjectReferenceRepresentation categoryRepr = new ObjectReferenceRepresentation();
        
        accountRepr.setId(task.getAccount().getId());
        categoryRepr.setId(task.getCategory().getId());
        result.setId(task.getId());
        result.setAccount(accountRepr);
        result.setCategory(categoryRepr);
        result.setLabel(task.getLabel());
        result.setDescription(task.getDescription());
        result.setImportance(task.getImportance());
        result.setUrgency(task.getUrgency());
        
        return result;
    }
    
    private Task model(TaskRepresentation repr) {
        Task task = new Task();

        task.setAccount(accountRepository.findOne(repr.getAccount().getId()));
        task.setCategory(categoryRepository.findOne(repr.getCategory().getId()));
        task.setLabel(repr.getLabel());
        task.setDescription(repr.getDescription());
        task.setImportance(repr.getImportance());
        task.setUrgency(repr.getUrgency());
        
        return task;
    }
}
