/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nl.fontys.sevenlo.jee.taskmanager.repository;

import java.util.Date;
import java.util.List;
import nl.fontys.sevenlo.jee.taskmanager.model.Account;
import nl.fontys.sevenlo.jee.taskmanager.model.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Vincent Wochnik <v.wochnik@gmail.com>
 */
public interface SessionRepository extends JpaRepository<Session, Long> {
    
    @Query("select s from Session s where s.securityToken = ?1 and s.lastAccess >= ?2")
    Session findByTokenAndAccess(String securityToken, Date lastAccess);
    
    List<Session> findByAccount(Account account);
}
