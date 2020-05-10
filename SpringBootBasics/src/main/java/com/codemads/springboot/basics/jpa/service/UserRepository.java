/**
 * 
 */
package com.codemads.springboot.basics.jpa.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codemads.springboot.basics.jpa.entity.User;


/**
 * 
 * UserRepository extends JPARepository which provides number of predefined functions to perform CRUD operations
 * 
 * use @Repository tag to make it a JPA Repo
 * 
 * @author girishgowda
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
