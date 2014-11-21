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
import nl.fontys.sevenlo.jee.taskmanager.exception.InvalidRepresentationException;
import nl.fontys.sevenlo.jee.taskmanager.exception.ResourceNotFoundException;
import nl.fontys.sevenlo.jee.taskmanager.model.Account;
import nl.fontys.sevenlo.jee.taskmanager.repository.AccountRepository;
import nl.fontys.sevenlo.jee.taskmanager.representation.AccountRepresentation;
import org.springframework.stereotype.Service;

/**
 *
 * @author Vincent Wochnik <v.wochnik@gmail.com>
 */
@Service
public class AccountService {
    
    @Resource
    private AccountRepository accountRepository;
    
    public List<AccountRepresentation> getAll() {
        List<AccountRepresentation> resultList = new ArrayList<AccountRepresentation>();
        
        for (Account account : accountRepository.findAll()) {
            resultList.add(representation(account));
        }
        
        return resultList;
    }
    
    public AccountRepresentation get(Long id) {
        Account account = accountRepository.getOne(id);
        if (account == null)
            throw new ResourceNotFoundException("Account ID not found.");

        return representation(account);
    }
    
    public AccountRepresentation create(AccountRepresentation repr) {
        if (repr.getId() != null)
            throw new InvalidRepresentationException("Resource ID must not be specified for a create operation.");

        Account account = model(repr);
        account = accountRepository.save(account);
        if (account == null)
            throw new DatabaseException("Account could not be created.");

        return representation(account);
    }
    
    public AccountRepresentation update(Long id, AccountRepresentation repr) {
        if ((repr.getId() != null) && (!repr.getId().equals(id)))
            throw new InvalidRepresentationException("Resource ID does not match resource URI.");

        Account account = model(repr);
        account.setId(id);
        account = accountRepository.save(account);
        if (account == null)
            throw new DatabaseException("Account could not be updated.");

        return representation(account);
    }
    
    public void delete(Long id) {
        accountRepository.delete(id);
    }
    
    private AccountRepresentation representation(Account account) {
        AccountRepresentation result = new AccountRepresentation();
        
        result.setId(account.getId());
        result.setDisplayName(account.getDisplayName());
        result.setEmail(account.getEmail());
        result.setPassword(account.getPassword());
        
        return result;
    }
    
    private Account model(AccountRepresentation repr) {
        Account account = new Account();

        account.setDisplayName(repr.getDisplayName());
        account.setEmail(repr.getEmail());
        account.setPassword(repr.getPassword());
        
        return account;
    }
}
