/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nl.fontys.sevenlo.jee.taskmanager.repository;

import java.util.List;
import nl.fontys.sevenlo.jee.taskmanager.model.Account;
import nl.fontys.sevenlo.jee.taskmanager.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Vincent Wochnik <v.wochnik@gmail.com>
 */
public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query("select t from Category t where t.account = ?1")
    List<Category> findByAccount(Account account);
}
