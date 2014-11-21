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
import nl.fontys.sevenlo.jee.taskmanager.repository.AccountRepository;
import nl.fontys.sevenlo.jee.taskmanager.repository.CategoryRepository;
import nl.fontys.sevenlo.jee.taskmanager.representation.AccountRepresentation;
import nl.fontys.sevenlo.jee.taskmanager.representation.CategoryRepresentation;
import nl.fontys.sevenlo.jee.taskmanager.representation.ObjectReferenceRepresentation;
import org.springframework.stereotype.Service;

/**
 *
 * @author Vincent Wochnik <v.wochnik@gmail.com>
 */
@Service
public class CategoryService {
    
    @Resource
    private CategoryRepository categoryRepository;
    @Resource
    private AccountRepository accountRepository;
    
    public List<CategoryRepresentation> getAll(Long accountId) {
        List<CategoryRepresentation> resultList = new ArrayList<CategoryRepresentation>();
        
        Account account = accountRepository.findOne(accountId);
        if (account == null)
            throw new InvalidQueryException("Account ID not found.");

        for (Category category : categoryRepository.findByAccount(account)) {
            resultList.add(representation(category));
        }
        
        return resultList;
    }
    
    public CategoryRepresentation get(Long id) {
        //TODO: implement
        return null;
    }
    
    public CategoryRepresentation create(CategoryRepresentation repr) {
        if (repr.getId() != null)
            throw new InvalidRepresentationException("Resource ID must not be specified for a create operation.");

        Category category = model(repr);
        if (category.getAccount() == null)
            throw new InvalidRepresentationException("Invalid account ID specified.");

        category = categoryRepository.save(category);
        if (category == null)
            throw new DatabaseException("Category could not be created.");

        return representation(category);
    }
    
    public CategoryRepresentation update(Long id, CategoryRepresentation repr) {
        if ((repr.getId() != null) && (!repr.getId().equals(id)))
            throw new InvalidRepresentationException("Resource ID does not match resource URI.");

        Category category = model(repr);
        category.setId(id);
        if (category.getAccount() == null)
            throw new InvalidRepresentationException("Invalid account ID specified.");

        category = categoryRepository.save(category);
        if (category == null)
            throw new DatabaseException("Category could not be updated.");

        return representation(category);
    }
    
    public void delete(Long id) {
        //TODO: implement
    }
    
    private CategoryRepresentation representation(Category category) {
        //TODO: implement
        return null;
    }
    
    private Category model(CategoryRepresentation repr) {
        //TODO: implement
        return null;
    }
}
