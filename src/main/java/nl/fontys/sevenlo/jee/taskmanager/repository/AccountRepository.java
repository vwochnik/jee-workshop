/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nl.fontys.sevenlo.jee.taskmanager.repository;

import nl.fontys.sevenlo.jee.taskmanager.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Vincent Wochnik <v.wochnik@gmail.com>
 */
public interface AccountRepository extends JpaRepository<Account, Long> {
    
    @Query("select a from Account a where a.email = ?1")
    Account findByEmail(String email);

    @Query("select a from Account a where a.email = ?1 and a.password = ?2")
    Account findByEmailAndPassword(String email, String password);
}
